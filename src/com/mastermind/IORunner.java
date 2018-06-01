package com.mastermind;

import java.lang.reflect.Method;
import java.util.*;

public class IORunner implements Runnable
{
    private Scanner scanner;
    private ComponentRunner componentRunner;

    public IORunner(ComponentRunner runner)
    {
        scanner = new Scanner(System.in);
        componentRunner = runner;
    }

    public void run()
    {
        while(true)
        {
            String command = scanner.nextLine();
            try{
                Method method = this.getClass().getMethod(command);
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
        System.out.println(prettyLine("help", "A list of available Commands"));
        System.out.println(prettyLine("list", "List all current ECO processes and their provided and required resources"));
        System.out.println(prettyLine("rum", "Prints an RUM of the entire system"));
        System.out.println(prettyLine("test", "Creates a dummy Eco process"));
        System.out.println(prettyLine("exit", "Terminate the Mastermind"));
        System.out.println("");
    }

    public void test()
    {
        Test t = new Test();
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
            Iterator it = e.getProvidedResources().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                System.out.println(prettyLine(pair.getKey().toString(), pair.getValue().toString()));
                it.remove(); // avoids a ConcurrentModificationException
            }

            // Iterate over the required resources
            System.out.println(dash());
            System.out.println("Required:");
            it = e.getVirtualRequiredResources().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                System.out.println(prettyLine(pair.getKey().toString(), pair.getValue().toString()));
                it.remove(); // avoids a ConcurrentModificationException
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
            Iterator it = e.getProvidedResources().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if(hm.get(pair.getKey().toString()) == null)
                {
                    hm.put(pair.getKey().toString(), (int) pair.getValue());
                } else {
                    int amount = hm.get(pair.getKey().toString());
                    hm.put(pair.getKey().toString(), (int) pair.getValue() + amount);
                }
                it.remove(); // avoids a ConcurrentModificationException
            }
        }

        // Print the hashmap
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(prettyLine(pair.getKey().toString(), pair.getValue().toString()));
            it.remove(); // avoids a ConcurrentModificationException
        }

        // Idem with required
        hm = new HashMap<>();
        System.out.println("");
        System.out.println("Total Resources Required:");
        for (EcoProcess e : processes)
        {
            it = e.getVirtualRequiredResources().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if(hm.get(pair.getKey().toString()) == null)
                {
                    hm.put(pair.getKey().toString(), (int) pair.getValue());
                } else {
                    int amount = hm.get(pair.getKey().toString());
                    hm.put(pair.getKey().toString(), (int) pair.getValue() + amount);
                }
                it.remove(); // avoids a ConcurrentModificationException
            }
        }

        // Print the hashmap
        it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(prettyLine(pair.getKey().toString(), pair.getValue().toString()));
            it.remove(); // avoids a ConcurrentModificationException
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
