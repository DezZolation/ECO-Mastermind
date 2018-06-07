package com.mastermind;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class EcoProcess
{
    private Socket socket;
    private ComponentRunner componentRunner;
    private HashMap<String, Integer> virtualResourceSupply;
    private HashMap<String, Integer> peakResourceDemand;
    private HashMap<String, Integer> providedResources;
    private int id;
    private PrintWriter output;
    private BufferedReader input;
    private Thread runner;

    public EcoProcess(Socket clientSocket, ComponentRunner c, int _id)
    {
        socket = clientSocket;
        componentRunner = c;
        id = _id;
        virtualResourceSupply = new HashMap<>();
        peakResourceDemand = new HashMap<>();
        providedResources = new HashMap<>();

        try{
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            }
            catch(SocketException e){
                terminate();
            }
            catch(Exception e){
                System.out.println(e);
            }

        // Create the eco process runner so it can accept incoming communication from the eco process
        runner = new Thread(new EcoProcessRunner(input, output, this));
        runner.start();
    }

    public void terminate()
    {
        System.out.println("Process " + id + " terminated");
        runner.interrupt();
        componentRunner.terminateProcess(this);
    }

    public boolean requiresResource(String resource)
    {
        return peakResourceDemand.containsKey(resource);
    }

    public void updatePeakResourceDemand(String resource, int demand)
    {
        peakResourceDemand.put(resource, demand);
        componentRunner.reschedule();
    }

    public void updateProvidedResources(String resource, int provided)
    {
        providedResources.put(resource, provided);
        componentRunner.reschedule();
    }

    /**
     * @return float that represents the average share this process has to all resources in the system
     */
    public Float averageShare()
    {
        float shareSum = 0;
        for(Map.Entry<String, Integer> entry : providedResources.entrySet())
        {
            int total = componentRunner.getTotalProvidedResource(entry.getKey());
            shareSum += ((float) entry.getValue() / total);
        }

        return shareSum / providedResources.size();
    }

    /**
     * @return a hashmap of the peak resource demands of the process based on highest performance. Can also be used to evaluate which resources are required
     */
    public HashMap<String, Integer> getPeakResourceDemand()
    {
        return peakResourceDemand;
    }

    /**
     * @return a hashmap of all the resources that are supplied to the process
     */
    public HashMap<String, Integer> getVirtualSuppliedResources()
    {
        return virtualResourceSupply;
    }

    /**
     * @return a hashmap of all the resources that are provided by the process
     */
    public HashMap<String, Integer> getProvidedResources()
    {
        return providedResources;
    }

    public HashMap<String, Integer> getVirtualProvidedResources()
    {
        HashMap<String, Integer> returnedMap = new HashMap<>();
        float shareSum = 0;

        for(Map.Entry<String, Integer> pair : getVirtualSuppliedResources().entrySet())
        {
            if(getPeakResourceDemand().containsKey(pair.getKey()))
            {
                shareSum = (float) pair.getValue() / (float) getPeakResourceDemand().get(pair.getKey());
            }
        }
        float share = shareSum / getVirtualSuppliedResources().size();

        for(Map.Entry<String, Integer> pair : getProvidedResources().entrySet())
        {
            returnedMap.put(pair.getKey(), (int) Math.floor(pair.getValue() * share));
        }

        return returnedMap;
    }

    public void setVirtualResourceSupply(String resourceName, int amount)
    {
        virtualResourceSupply.put(resourceName, amount);
        output.println("update " + resourceName + " " + amount);
    }

    public int getId()
    {
        return id;
    }
}
