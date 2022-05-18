package com.dsavisualizer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IntegerListPrompter
{
    //Fields--------------------------------------------------------------------
    //--------------------------------------------------------------------------
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
                if(integerList.contains(number))
                    duplicateValueMessage(number);
                else if (number > -1 && number < 101)
                    integerList.add(number);
                else invalidRangeMessage(number);
            }
            else invalidInputMessage(i);
        }
        //-----------------------------------------

        add(meetsValuesNeeded());//Recurse if does not meet values needed
    }
    //Overloaded add method
    public void add(boolean meetValuesNeeded)
    {
        if(meetValuesNeeded)
            return;
        //else
        System.out.println("Please add more values");
        add();
    }
    boolean meetsValuesNeeded()
    {
        if(getIntegerList().size() < VALUES_NEEDED)
        {
            System.out.println("You did not meet the required amount of values needed for the Data Structure");
            return false;
        }
        //else
        return true;
    }
    //TODO: Make Exceptions for these errors instead of method messages
    void invalidInputMessage(String invalid)
    {
        System.out.println("The input \"" +  invalid + "\" is invalid and cannot be added to your list");
    }
    void duplicateValueMessage(int duplicateValue)
    {
        System.out.println("The input \"" +  duplicateValue + "\" is already in the list and cannot be added again");
    }
    void invalidRangeMessage(int invalidRange)
    {
        System.out.println("The input \"" +  invalidRange + "\" is out of the specified range and cannot be added to your list");
    }

    //Getters & Setters---------------------------------------------------------
    //--------------------------------------------------------------------------
    public LinkedList<Integer> getIntegerList()
    {
        return integerList;
    }

    //--------------------------------------------------------------------------
    //Meant to test the add method
    //     public static void main(String[] args)
    //     {
    //         LinkedList<Integer> list = new LinkedList<>();
    //         IntegerListPrompter prompter = newInstance(list, 2);
    //         prompter.add();
    //         System.out.println(Arrays.toString(prompter.getIntegerList().toArray()));
    //     }
}