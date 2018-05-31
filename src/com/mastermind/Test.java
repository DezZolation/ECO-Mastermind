package com.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Test
{
    public Test()
    {
        try{
            Socket s = new Socket("127.0.0.1", 9042);
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(s.getInputStream()));
            String answer = input.readLine();
            System.out.println("The answer is: " + answer);
        }    catch(IOException v) {
            System.out.println(v);
        }
    }
}
