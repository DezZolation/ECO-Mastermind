package com.mastermind;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;

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

        // This line is here because we need to initialize something. considering eco won't ask us for a specific resource (tsupply), we are just going to return power
        setVirtualResourceSupply("power", 500);

        // Let's start by requesting the peak demand of all the required resources
        output.println("peak");

        // Then also ask about the provided resources
        output.println("provided");

        // Now create the eco process runner so it can accept incoming communication from the eco process
        runner = new Thread(new EcoProcessRunner(input, output, this));
        runner.start();
    }

    public void terminate()
    {
        System.out.println("Process " + id + " terminated");
        runner.interrupt();
        componentRunner.terminateProcess(this);
    }

    public void updatePeakResourceDemand(String resource, int demand)
    {
        peakResourceDemand.put(resource, demand);
    }

    public void updateProvidedResources(String resource, int provided)
    {
        providedResources.put(resource, provided);
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
