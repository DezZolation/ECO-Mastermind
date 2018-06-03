package com.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import java.util.HashMap;

public class EcoProcessRunner implements Runnable
{
    private BufferedReader input;
    private PrintWriter output;
    private EcoProcess ecoProcess;
    private boolean running;

    public EcoProcessRunner(BufferedReader in, PrintWriter out, EcoProcess process)
    {
        input = in;
        output = out;
        ecoProcess = process;
        running = true;
    }

    public void run()
    {
        while(running) {
            try{
                String[] split = input.readLine().split(" ");

                // peak <resource> <amount>, put it in the correct hashmap
                if(split[0].equals("peak"))
                {
                    ecoProcess.updatePeakResourceDemand(split[1], Integer.parseInt(split[2]));
                }

                // provided <resource> <amount>, put it in the correct hashmap
                if(split[0].equals("provided"))
                {
                    ecoProcess.updateProvidedResources(split[1], Integer.parseInt(split[2]));
                }

                // resource <resource>, the process can request a resource, in that case it should be updated from virtual supply
                if(split[0].equals("resource"))
                {
                    HashMap<String, Integer> virtualResourceSupply = ecoProcess.getVirtualSuppliedResources();
                    if(virtualResourceSupply.containsKey(split[1]))
                    {
                        output.println("update " + split[1] + " " + virtualResourceSupply.get(split[1]).toString());
                    }
                }
            }catch(SocketException e){
                ecoProcess.terminate();
                running = false;
            }catch(IOException e)
            {
                System.out.println(e);
                running = false;
            }
        }
    }
}
