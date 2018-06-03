package com.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test
{
    private HashMap<String, Integer> virtualResourceSupply;
    private HashMap<String, Integer> peakResourceDemand;
    private HashMap<String, Integer> providedResources;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public Test()
    {
        virtualResourceSupply = new HashMap<>();
        peakResourceDemand = new HashMap<>();
        providedResources = new HashMap<>();

        try
        {

            socket = new Socket("127.0.0.1", 9042);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            while(true)
            {
                // Split the command string by space seperators
                String[] split = input.readLine().split(" ");

                // Handle peak command
                if(split[0].equals("peak"))
                {
                    // Loop over all demanded resources and send them to the server
                    Iterator i = peakResourceDemand.entrySet().iterator();
                    while(i.hasNext())
                    {
                        Map.Entry pair = (Map.Entry)i.next();
                        output.println("peak " + pair.getKey() + " " + pair.getValue().toString());
                        i.remove();
                    }
                }

                // Handle update of virtualResourceSupply
                if(split[0].equals("update"))
                {
                    virtualResourceSupply.put(split[1], Integer.parseInt(split[2]));
                }

                // Handle provided command
                if(split[0].equals("provided"))
                {
                    // Loop over all provided resources and send them to the server
                    Iterator i = providedResources.entrySet().iterator();
                    while(i.hasNext())
                    {
                        Map.Entry pair = (Map.Entry)i.next();
                        output.println("provided " + pair.getKey() + " " + pair.getValue().toString());
                        i.remove();
                    }
                }
            }
        }catch(ConnectException e){

        }
        catch(IOException v)
        {
            System.out.println(v);
        }
    }

    /**
     * @param resource The resource that needs to be provided
     * @return an integer of the virtual supply of the resource
     */
    public int getResourceSupply(String resource)
    {
        // Return the stored resource supply
        if(virtualResourceSupply.containsKey(resource))
        {
            return virtualResourceSupply.get(resource);
        }

        // If no supply is stored, we're going to request it from the server.
        // In the meantime we will return 0
        output.println("resource " + resource);

        return 0;
    }
}
