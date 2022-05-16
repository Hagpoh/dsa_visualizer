package com.dsavisualizer;

import java.util.List;
import java.util.Scanner;

public class IntegerListPrompter {
    //Fields--------------------------------------------------------------------
    //--------------------------------------------------------------------------
    private Scanner scanner = new Scanner(System.in);
    private final int valuesNeeded;
    private List<Integer> integerList;

    //Constructor---------------------------------------------------------------
    //--------------------------------------------------------------------------
    private IntegerListPrompter(List<Integer> integerList, int valuesNeeded) {

        //empty collection
        //TODO: Check to ensure it is empty and not improper type (exceptions)

        this.valuesNeeded = valuesNeeded;
        this.integerList = integerList;
    }

    public static IntegerListPrompter newInstance(List<Integer> integerList, int valuesNeeded) {
        return new IntegerListPrompter(integerList, valuesNeeded);
    }

    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public void add() {
        while (true) {
            System.out.print("If you wish to quit enter [Q]\n\n" +
                    "To add starting values to your list enter a number from 1-100:");
            String input = scanner.next();
            int number;
            if (input.matches("\\d{1,3}")) {
                number = Integer.parseInt(input);
                if (number > -1 && number < 101)
                    integerList.add(number);
            }

            //Exit loop
            //TODO: Make sure List has sufficient enough values for algorithm
            if (input.equals("q") && integerList.size() < valuesNeeded)
                System.out.format("\nYou need %d values in your list.\nYou have %d. Please continue to add more values.", valuesNeeded, integerList.size());
            else if (input.equals("q")) // AND therefore must be equal to or greater than the values needed
                break;
        }
    }
}