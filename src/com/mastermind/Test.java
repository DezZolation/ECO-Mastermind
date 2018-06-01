package com.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Test
{
    public Test()
    {
        try
        {
            Socket socket = new Socket("127.0.0.1", 9042);
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while(true)
            {
                String[] split = input.readLine().split(" ");
                if(split[0].equals("peak"))
                {
                    output.println(42);
                }
            }
        }catch(IOException v)
        {
            System.out.println(v);
        }

        // Implement commands:
        // update <resourcename> <amount>   (update the battery of the required resource with <amount>)
        // peak <resourcename>              (return peak of that resource)
        // provided                         (return all provided resources)

    }
}
