package com.dsavisualizer.app;

import com.dsavisualizer.BinarySearchTree;

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
        //WE NEED AN EMTPY TREE
        //Check to ensure it is empty and not improper type (exceptions)
        if (!tree.isEmpty() || valuesNeeded < 1)
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
                if (tree.contains(number))
                    duplicateValueMessage(number);
                else if (number > -1 && number < 101)
                    tree.insert(number);
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
        if (tree.size() < VALUES_NEEDED)
        {

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