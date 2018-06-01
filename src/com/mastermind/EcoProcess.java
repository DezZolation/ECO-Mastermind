package com.mastermind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;

public class EcoProcess implements Runnable
{
    private Socket socket;
    private ComponentRunner componentRunner;
    private HashMap<String, Integer> virtualResourceSupply;
    private int id;
    private PrintWriter output;
    BufferedReader input;

    public EcoProcess(Socket clientSocket, ComponentRunner c, int _id)
    {
        socket = clientSocket;
        componentRunner = c;
        id = _id;
        virtualResourceSupply = new HashMap<>();

        try{
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            }
            catch(SocketException e){
                componentRunner.terminateProcess(this);
            }
            catch(Exception e){
                System.out.println(e);
            }

        // This line is here because we need to initialize something. considering eco won't ask us for a specific resource (tsupply), we are just going to return power
        setVirtualResourceSupply("power", 500);
    }

    public void run()
    {
        System.out.println("New Process subscribed. Total: " + componentRunner.getProcesses().size());

        while(true) {
            try{
                String[] split = input.readLine().split(" ");
                if(split[0].equals("resource"))
                {
                    output.println(virtualResourceSupply.get(split[1]));
                }
            }catch(IOException e)
            {
                System.out.println(e);
            }
        }
    }

    public void setVirtualResourceSupply(String resourceName, int amount)
    {
        virtualResourceSupply.put(resourceName, amount);
        output.println("update " + resourceName + " " + amount);
        //TODO: Make this work at the eco code
    }

    public int getVirtualResourceSupply(String resourceName)
    {
        return virtualResourceSupply.get(resourceName);
    }

    public int getResourcePeakDemand(String resourceName)
    {
        //TODO: Make this work at the eco code
        output.println("peak " + resourceName);
        return 0;
    }

    public HashMap<String, Integer> getVirtualRequiredResources()
    {
        return virtualResourceSupply;
    }

    public HashMap<String, Integer> getProvidedResources()
    {
        //TODO: Make this work at the eco code
        output.println("provided");
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("Water", 42);
        hm.put("Oil", 13);
        return hm;
    }

    public int getId()
    {
        return id;
    }
}
