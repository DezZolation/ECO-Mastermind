package com.mastermind;

import java.util.Scanner;

public class IORunner implements Runnable
{
    private Mastermind mastermind;
    private Scanner scanner;

    public IORunner(Mastermind m)
    {
        this.scanner = new Scanner(System.in);
        this.mastermind = m;
    }

    public void run()
    {
        while(true)
        {
            String command = scanner.nextLine();
            if(command.equals("test"))
            {
                Test t = new Test();
            }
            if(command.equals("exit"))
            {
                System.exit(0);
            }
        }
    }
}
