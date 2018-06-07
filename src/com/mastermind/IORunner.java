package com.mastermind;

import java.lang.reflect.Method;
import java.util.*;

public class IORunner implements Runnable
{
    private Scanner scanner;
    private ComponentRunner componentRunner;
    private String command;

    public IORunner(ComponentRunner runner)
    {
        scanner = new Scanner(System.in);
        componentRunner = runner;
    }

    public void run()
    {
        while(true)
        {
            command = scanner.nextLine();

            try{
                String[] split = command.split(" ");
                Method method = this.getClass().getMethod(split[0]);
                method.invoke(this);
            }
            catch(NoSuchMethodException e)
            {
                System.out.println("Unknown commmand, type help");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public void help()
    {
        System.out.println(prettyLine("Command", "Description"));
        System.out.println(dash());
        System.out.println(prettyLine("supply <resource> <amount>", "Adds a resource to the general supply, use -1 for an infite supply"));
        System.out.println(prettyLine("list", "List all current ECO processes and their provided and required resources"));
        System.out.println(prettyLine("rum", "Prints an RUM of the entire system"));
        System.out.println(prettyLine("exit", "Terminate the Mastermind"));
        System.out.println("");
    }

    public void supply()
    {
        String[] split = command.split(" ");
        componentRunner.getResources().put(split[1], Integer.parseInt(split[2]));
        componentRunner.reschedule();
    }

    public void list()
    {
        List<EcoProcess> processes = componentRunner.getProcesses();
        for (EcoProcess e : processes)
        {
            System.out.println(doubleDash());
            System.out.println(prettyLine("ID:", Integer.toString(e.getId())));

            // Iterate over the provided resources
            System.out.println(dash());
            System.out.println("Provided:");
            for(Map.Entry pair : e.getVirtualProvidedResources().entrySet()) {
                System.out.println(prettyLine(pair.getKey().toString(), pair.getValue().toString()));
            }

            // Iterate over the required resources
            System.out.println(dash());
            System.out.println("Required:");
            for(Map.Entry pair : e.getVirtualSuppliedResources().entrySet()) {
                System.out.println(prettyLine(pair.getKey().toString(), pair.getValue().toString()));
            }
        }
    }

    public void rum()
    {
        List<EcoProcess> processes = componentRunner.getProcesses();
        HashMap<String, Integer> hm = new HashMap<>();

        // Build the hashmap out of the total of resources provided
        System.out.println("Total Resources Provided:");
        for (EcoProcess e : processes)
        {
            for (Map.Entry pair : e.getVirtualProvidedResources().entrySet()) {
                if(hm.get(pair.getKey().toString()) == null)
                {
                    hm.put(pair.getKey().toString(), (int) pair.getValue());
                } else {
                    int amount = hm.get(pair.getKey().toString());
                    hm.put(pair.getKey().toString(), (int) pair.getValue() + amount);
                }
            }
        }

        // Print the hashmap
        for(Map.Entry pair : hm.entrySet()) {
            System.out.println(prettyLine(pair.getKey().toString(), pair.getValue().toString()));
        }

        // Idem with required
        hm = new HashMap<>();
        System.out.println("");
        System.out.println("Total Resources Required:");
        for (EcoProcess e : processes)
        {
            for (Map.Entry pair : e.getVirtualSuppliedResources().entrySet()) {
                if(hm.get(pair.getKey().toString()) == null)
                {
                    hm.put(pair.getKey().toString(), (int) pair.getValue());
                } else {
                    int amount = hm.get(pair.getKey().toString());
                    hm.put(pair.getKey().toString(), (int) pair.getValue() + amount);
                }
            }
        }

        // Print the hashmap
        for (Map.Entry  pair : hm.entrySet()) {
            System.out.println(prettyLine(pair.getKey().toString(), pair.getValue().toString()));
        }
    }

    public void exit()
    {
        System.exit(0);
    }

    public String prettyLine(String left, String right)
    {
        int margin = 50;
        StringBuilder line = new StringBuilder();
        line.append(left);
        for (int i = 0; i < margin - left.length(); i++)
        {
            line.append(" ");
        }
        line.append(right);
        return line.toString();
    }

    public String dash()
    {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 80; i++)
        {
            line.append("-");
        }
        return line.toString();
    }

    public String doubleDash()
    {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 80; i++)
        {
            line.append("=");
        }
        return line.toString();
    }
}
