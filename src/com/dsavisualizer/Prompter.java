package com.dsavisualizer;

abstract class Prompter
{
    //Fields--------------------------------------------------------------------
    //--------------------------------------------------------------------------

    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
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
}