package com.mastermind;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ComponentRunner implements Runnable
{
    private Mastermind mastermind;

    public ComponentRunner(Mastermind m)
    {
        this.mastermind = m;
    }

    public void run()
    {
        try {
            ServerSocket listener = new ServerSocket(9042);
            try{
                while(true) {
                    Socket socket = listener.accept();
                    try {
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.println(new Date().toString());
                    } finally {
                        socket.close();
                    }
                }
            } finally {
                listener.close();
            }
        } catch(IOException v)
        {
            System.out.println(v);
        }

        /*while(true)
        {
            mastermind.increment();
            try
            {
                Thread.sleep(1000);
            } catch(InterruptedException v) {
                System.out.println(v);
            }
        }*/

    }
}
