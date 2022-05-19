package com.dsavisualizer.app;

import com.dsavisualizer.LinkedList;
import com.dsavisualizer.app.Prompter;

import java.util.Scanner;

public class IntegerListPrompter extends Prompter
{
    //Fields--------------------------------------------------------------------
    //--------------------------------------------------------------------------
    private final int VALUES_NEEDED;
    private LinkedList integerList;

    //Constructor---------------------------------------------------------------
    //--------------------------------------------------------------------------
    private IntegerListPrompter(LinkedList integerList, int valuesNeeded)
    {
        this.VALUES_NEEDED = valuesNeeded;
        this.integerList = integerList;
    }

    public static IntegerListPrompter newInstance(LinkedList integerList, int valuesNeeded)
    {
        //Check to ensure it is empty and not improper type (exceptions)
        if (!integerList.isEmpty() || valuesNeeded < 1)
            throw new IllegalArgumentException();

        return new IntegerListPrompter(integerList, valuesNeeded);
    }

    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public void add()
    {

        System.out.print("Enter the List's values separated by a comma\nOnly unique values from 1-100 accepted]: ");
        String input = new Scanner(System.in).nextLine();

        //-----------------------------------------
        for (var i : input.split(","))
        {
            i = i.trim();
            int number;
            if (i.matches("\\d{1,3}"))
            {
                number = Integer.parseInt(i);
                if (integerList.contains(number))
                    duplicateValueMessage(number);
                else if (number > -1 && number < 101)
                    integerList.addNode(number);
                else invalidRangeMessage(number);
            } else invalidInputMessage(i);
        }
        //-----------------------------------------

        add(meetsValuesNeeded());//Recurse if does not meet values needed
    }

    //Overloaded add method
    public void add(boolean meetValuesNeeded)
    {
        if (meetValuesNeeded)
            return;
        //else
        addMoreValuesMessage();
        add();
    }

    boolean meetsValuesNeeded()
    {
        if (getIntegerList().size() < VALUES_NEEDED)
        {

            return false;
        }
        //else
        return true;
    }

    //Getters & Setters---------------------------------------------------------
    //--------------------------------------------------------------------------
    public LinkedList getIntegerList()
    {
        return integerList;
    }

    //--------------------------------------------------------------------------
    //Meant to test the add method
    //     public static void main(String[] args)
    //     {
    //         LinkedList list = new LinkedList<>();
    //         IntegerListPrompter prompter = newInstance(list, 2);
    //         prompter.add();
    //         System.out.println(Arrays.toString(prompter.getIntegerList().toArray()));
    //     }


    //TODO: ask package which classes implement datastructure interface
    // KLASS
    // Package
    //TODO: Then call get name


    //Data structure interface has method get algorthims which returns an array of algorithm and an array of string
    //foreach data structure. Grab supported algorithms
    // return as strings


    //TODO: Algorithm interface.. searchable extends Algorithm
}