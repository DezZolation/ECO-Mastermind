package com.mastermind;

public class Mastermind
{
    private int counter;

    public Mastermind()
    {
        counter = 0;

        Runnable counter = new ComponentRunner(this);
        new Thread(counter).start();

        Runnable printer = new IORunner(this);
        new Thread(printer).start();
    }

    public int getCounter()
    {
        return counter;
    }

    public void increment()
    {
        counter++;
    }
}
