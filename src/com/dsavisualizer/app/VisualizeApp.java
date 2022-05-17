package com.dsavisualizer.app;

import com.dsavisualizer.LinkedListVisual;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class VisualizeApp {
    boolean exit;
    int dataStructureSelection;
    int algorithmSelection;

    public void execute() {
        welcomeHeader();
        while (!exit) {
            promptForDataStructure();
            dataStructureSelection = getMenuInput();
            promptForAlgorithm();
            algorithmSelection = getMenuInput();
            performSelection();
        }
    }

    private void performSelection() {
        switch (dataStructureSelection) {
            case 1: //Linked List
                LinkedListVisual list = new LinkedListVisual(new LinkedList<>(Arrays.asList(1, 9, 15, 4, 8, 15))); //TODO add method for setting list
                switch (algorithmSelection) {
                    case 1: //sort
                        list.sort();
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


    private int getMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;

        while (input < 0) {
            try {
                System.out.print("Enter your choice: ");
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please enter a valid selection.");
            }
        }
        if (input == 0) {
            System.out.println("Thanks for using the DSA Analyzer!");
            System.exit(0);
        }
        return input;
    }

    private int getIntInput() {
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection. Please enter a valid selection.");
        }
        return input;
    }

    //TODO update to be dynamic based off of data structures and algorithms implemented.
    private void promptForDataStructure() {
        System.out.println("Please select a data structure: ");
        System.out.println("1. Linked List");
        System.out.println("2. Binary Search Tree");
        System.out.println("0. Exit");
    }

    //TODO update to be dynamic based off of data structures and algorithms implemented.
    private void promptForAlgorithm() {
        System.out.println("Please select an algorithm: ");
        switch (dataStructureSelection) {
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

    private void welcomeHeader() {
        try {
            List<String> welcome = Files.readAllLines(Path.of("resources/welcome.txt"));
            for (String line : welcome) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}