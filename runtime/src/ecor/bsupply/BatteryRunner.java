package ecor.bsupply;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ecor.bsupply.VirtualBareMetalBattery;
import java.io.IOException;

public class BatteryRunner implements Runnable {

    BufferedReader input;
    PrintWriter output;
    VirtualBareMetalBattery battery;

    public BatteryRunner(BufferedReader in, PrintWriter out, VirtualBareMetalBattery b)
    {
        input = in;
        output = out;
        battery = b;
    }

    public void run()
    {
        try
        {
            while(true)
            {
                // Split the command string by space seperators
                String[] split = input.readLine().split(" ");

                // Handle peak command
                if(split[0].equals("peak"))
                {
                    // Loop over all demanded resources and send them to the server
                    Iterator i = battery.getPeakResourceDemand().entrySet().iterator();
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
                    battery.setVirtualResourceSupply(split[1], Integer.parseInt(split[2]));
                }

                // Handle provided command
                if(split[0].equals("provided"))
                {
                    // Loop over all provided resources and send them to the server
                    Iterator i = battery.getProvidedResources().entrySet().iterator();
                    while(i.hasNext())
                    {
                        Map.Entry pair = (Map.Entry)i.next();
                        output.println("provided " + pair.getKey() + " " + pair.getValue().toString());
                        i.remove();
                    }
                }
            }
        }catch(IOException v)
        {
            System.out.println(v);
        }
    }
}
