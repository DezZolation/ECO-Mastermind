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

                // Handle update of virtualResourceSupply
                if(split[0].equals("update"))
                {
                    battery.setVirtualResourceSupply(split[1], Integer.parseInt(split[2]));
                    System.out.println("Updated " + split[1] + " to " + split[2] );
                }
            }
        }catch(IOException v)
        {
            System.out.println(v);
        }
    }
}
