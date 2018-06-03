package com.mastermind;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ComponentRunner
{
    private List<EcoProcess> processes;
    private IORunner serverTerminal;
    private int processCounter;

    public ComponentRunner()
    {
        processes = new ArrayList<>();
        processCounter = 0;

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

    public void terminateProcess(EcoProcess p)
    {
        processes.remove(p);
    }
}
