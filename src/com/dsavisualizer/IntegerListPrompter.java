package com.dsavisualizer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IntegerListPrompter
{
    //Fields--------------------------------------------------------------------
    //--------------------------------------------------------------------------
    private Scanner scanner = new Scanner(System.in);
    private final int VALUES_NEEDED;
    private LinkedList<Integer> integerList;

    //Constructor---------------------------------------------------------------
    //--------------------------------------------------------------------------
    private IntegerListPrompter(LinkedList<Integer> integerList, int valuesNeeded)
    {
        //Check to ensure it is empty and not improper type (exceptions)
        if(!integerList.isEmpty() || valuesNeeded < 1)
            throw new IllegalArgumentException();

        this.VALUES_NEEDED = valuesNeeded;
        this.integerList = integerList;
    }

    public static IntegerListPrompter newInstance(LinkedList<Integer> integerList, int valuesNeeded)
    {
        return new IntegerListPrompter(integerList, valuesNeeded);
    }

    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public void add()
    {
        while (true)
        {
            System.out.print("If you wish to quit enter [Q]\n\n" +
                                     "To add starting values to your list enter a number from 1-100:");
            String input = scanner.next();
            int number;
            if (input.matches("\\d{1,3}"))
            {
                number = Integer.parseInt(input);
                if (number > -1 && number < 101)
                    integerList.add(number);
            }

            //Exit loop
            //TODO: allow user to type in numbers seperated by commas
            //TODO: Make sure List has sufficient enough values for algorithm
            if (input.equals("q") && integerList.size() < VALUES_NEEDED)
            {
                System.out.format("\nYou need %d values in your list.\nYou have %d. Please continue to add more values.", VALUES_NEEDED, integerList.size());
            }

            else if (input.equals("q")) // AND therefore must be equal to or greater than the values needed
                break;
        }
    }

    public List<Integer> getIntegerList()
    {
        return integerList;
    }


//    public static void main(String[] args)
//    {
//        LinkedList<Integer> list = new LinkedList<>();
//        IntegerListPrompter prompter = newInstance(list, 2);
//
//        prompter.add();
//
//    }
}