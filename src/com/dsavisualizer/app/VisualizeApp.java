package com.dsavisualizer.app;

import com.dsavisualizer.IntegerListPrompter;
import com.dsavisualizer.view.LinkedListVisual;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class VisualizeApp
{
    boolean exit;
    int dataStructureSelection;
    int algorithmSelection;

    public void execute()
    {
        welcomeHeader();
        while (!exit)
        {
            promptForDataStructure();
            dataStructureSelection = getMenuInput();
            promptForAlgorithm();
            algorithmSelection = getMenuInput();
            performSelection();
        }
    }

    //Performs the given action depending on the input provided by the user
    private void performSelection()
    {
        switch (dataStructureSelection)
        {
            case 1: //Linked List
                IntegerListPrompter prompter = IntegerListPrompter.newInstance(new LinkedList<Integer>(), 2);
                prompter.add();
                LinkedListVisual list = new LinkedListVisual(prompter.getIntegerList()); //TODO add method for setting list
                switch (algorithmSelection)
                {
                    case 1: //sort
                        list.sort(); //Call the method for sorting the Linked List here.
                        break;
                    case 2: //search
                        System.out.print("Please input an integer to search for: ");
                        list.search(getIntInput());
                        break;
                    case 3: //add
                        System.out.print("Please enter the index then value of what you want to add: ");
                        list.add(getIntInput(), getIntInput());
                }
                break;
            case 2: //Binary Search Tree
                System.out.println("Nothing for now");
        }
    }

    //TODO:GetDataStructureUpperBound() GetAlgorithmUpperBound() to know whether to throw OutOfBounds exception
    //TODO:Possibly use getIntInput() to clean this code up
    //Gets menu input
    private int getMenuInput()
    {
        Scanner scanner = new Scanner(System.in);
        int input = -1;

        while (input < 0)
        {
            try
            {
                System.out.print("Enter your choice: ");
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e)
            {
                System.out.println("Invalid selection. Please enter a valid selection.");
            }
        }
        if (input == 0)
        {
            System.out.println("Thanks for using the DSA Analyzer!");
            System.exit(0);
        }
        return input;
    }

    //Gets an integer value input
    int getIntInput() //package private to test
    {
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        try
        {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e)
        {
            System.out.println("Invalid selection. Please enter a valid selection.");
        }
        return input;
    }

    //TODO update to be dynamic based off of data structures and algorithms implemented.
    //Menu that prints Data Structure options
    private void promptForDataStructure() //TODO: if doing unit test, make this method package-private
    {
        System.out.println("Please select a data structure: ");
        System.out.println("1. Linked List");
        System.out.println("2. Binary Search Tree");
        System.out.println("0. Exit");
    }

    //TODO update to be dynamic based off of data structures and algorithms implemented.
    //Menu that prints algorithm options
    private void promptForAlgorithm()//TODO: if doing unit test, make this method package-private
    {
        System.out.println("Please select an algorithm: ");
        switch (dataStructureSelection)
        {
            case 1: //Linked List
                System.out.println("1. Sort");
                System.out.println("2. Search");
                System.out.println("3. Add");
                System.out.println("0. Exit");
                break;
            case 2: //Binary Search Tree
                System.out.println("Nothing right now");
        }
    }

    void welcomeHeader() //package private to test
    {
        try
        {
            List<String> welcome = Files.readAllLines(Path.of("resources/welcome.txt"));
            for (String line : welcome)
            {
                System.out.println(line);
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}