package com.dsavisualizer.app;

abstract class Prompter
{
    public abstract void add();
    public abstract void add(boolean meetsValuesNeeded);

    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //TODO: Make Exceptions for these errors instead of method messages
    void invalidInputMessage(String invalid)
    {
        System.out.println("The input \"" + invalid + "\" is invalid and cannot be added");
    }

    void duplicateValueMessage(int duplicateValue)
    {
        System.out.println("The input \"" + duplicateValue + "\" is already in the list and cannot be added again");
    }

    void invalidRangeMessage(int invalidRange)
    {
        System.out.println("The input \"" + invalidRange + "\" is out of the specified range and cannot be added");
    }
    void addMoreValuesMessage()
    {
        System.out.println("You did not meet the required amount of values needed for the Data Structure");
        System.out.println("Please add more values");
    }
}