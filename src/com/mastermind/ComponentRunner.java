package com.mastermind;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ComponentRunner
{
    private List<EcoProcess> processes;
    private HashMap<String, Integer> resources;

    public ComponentRunner()
    {
        processes = new ArrayList<>();
        int processCounter = 0;
        resources = new HashMap<>();

        resources.put("oil", 43);
        resources.put("power", 30);

        IORunner serverTerminal = new IORunner(this);
        new Thread(serverTerminal).start();

        try {
            ServerSocket listener = new ServerSocket(9042);

            while(true)
            {
                Socket socket = listener.accept();

                processCounter++;
                EcoProcess ecoProcess = new EcoProcess(socket, this, processCounter);
                processes.add(ecoProcess);
                System.out.println("New Process subscribed. Total: " + processes.size());
            }

        } catch(IOException v)
        {
            System.out.println(v);
        }

    }

    public List<EcoProcess> getProcesses()
    {
        return processes;
    }

    public HashMap<String, Integer> getResources() { return resources; };

    public void terminateProcess(EcoProcess p)
    {
        processes.remove(p);
        reschedule();
    }

    public int getTotalProvidedResource(String resource)
    {
        int sum = 0;
        for (EcoProcess e : processes)
        {
            if(e.getProvidedResources().containsKey(resource))
            {
                sum += e.getProvidedResources().get(resource);
            }
        }
        return sum;
    }

    /**
     * Reschedule the virtual resource supplies for all connected processes
     */
    public void reschedule()
    {
        // Loop over all supplied resources
            // For all eco processes
                 // if the process requires that resource
                    // if the resource has an infite supply (-1) then give the peak amount
                    // else give the resource either it's average share or it's peak amount

        for(Map.Entry<String, Integer> entry : resources.entrySet())
        {
            String resourceSupplied = entry.getKey();
            int totalSupplied = entry.getValue();
            for(EcoProcess e : processes)
            {
                if(e.requiresResource(resourceSupplied))
                {
                    int peakAmount = e.getPeakResourceDemand().get(resourceSupplied);
                    if(totalSupplied == -1)
                    {
                        e.setVirtualResourceSupply(resourceSupplied, peakAmount);
                    }
                    else
                    {
                        int averageShare = (int) Math.floor(totalSupplied * e.averageShare());
                        e.setVirtualResourceSupply(resourceSupplied, Math.min(averageShare, peakAmount));
                    }
                }
            }
        }
    }
}
