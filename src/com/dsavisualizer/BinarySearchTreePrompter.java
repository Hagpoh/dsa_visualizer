package com.dsavisualizer;

import com.dsavisualizer.BinarySearchTreePrompter;
import java.util.LinkedList;
import java.util.Scanner;

public class BinarySearchTreePrompter extends Prompter
{
    //Fields--------------------------------------------------------------------
    //--------------------------------------------------------------------------
    private final int VALUES_NEEDED;
    private BinarySearchTree tree;

    //Constructor---------------------------------------------------------------
    //--------------------------------------------------------------------------
    private BinarySearchTreePrompter(BinarySearchTree tree, int valuesNeeded)
    {
        this.VALUES_NEEDED = valuesNeeded;
        this.tree = tree;
    }

    public static BinarySearchTreePrompter newInstance(BinarySearchTree tree, int valuesNeeded)
    {
        //Check to ensure it is empty and not improper type (exceptions)
        if(!tree.isEmpty() || valuesNeeded < 1)
            throw new IllegalArgumentException();

        return new BinarySearchTreePrompter(tree, valuesNeeded);
    }

    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public void add()
    {

        System.out.print("Enter the Tree's values separated by a comma\nOnly unique values from 1-100 accepted]: ");
        String input = new Scanner(System.in).nextLine();

        //-----------------------------------------
        for (var i : input.split(","))
        {
            i = i.trim();
            int number;
            if (i.matches("\\d{1,3}"))
            {
                number = Integer.parseInt(i);
                if(tree.search(number))
                    duplicateValueMessage(number);
                else if (number > -1 && number < 101)
                    tree.insert(number);
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
        tree.balance();
        if(meetValuesNeeded)
            return;
        //else
        System.out.println("Please add more values");
        add();
    }
    boolean meetsValuesNeeded()
    {
        if(tree.size() < VALUES_NEEDED)
        {
            System.out.println("You did not meet the required amount of values needed for the Data Structure");
            return false;
        }
        //else
        return true;
    }


    //Getters & Setters---------------------------------------------------------
    //--------------------------------------------------------------------------
    public BinarySearchTree getTree()
    {
        return tree;
    }
}