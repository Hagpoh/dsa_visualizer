package com.dsavisualizer.app;

import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class VisualizeApp {

    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        welcome();
        promptForDataStructure();
        promptForAlgorithm();
    }

    //TODO update to be dynamic based off of data structures and algorithms implemented.
    private void promptForDataStructure() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please select a data structure to visualize: ");
            System.out.println("1. Linked List");
            String input = scanner.nextLine();
            if (input.matches("\\d")){
                int intInput = Integer.parseInt(input);
                switch (intInput){
                    case 1 :
                        System.out.println("You picked Linked List");
                        validInput = true;
                }
            }
        }
    }

    //TODO update to be dynamic based off of data structures and algorithms implemented.
    private void promptForAlgorithm() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please select an algorithm to visualize: ");
            System.out.println("1. Quick Sort");
            String input = scanner.nextLine();
            if (input.matches("\\d")){
                int intInput = Integer.parseInt(input);
                switch (intInput){
                    case 1 :
                        System.out.println("You picked Quick Sort");
                        validInput = true;
                }
            }
        }
    }

    private void welcome() {
        try {
            List<String> welcome = Files.readAllLines(Path.of("resources/welcome.txt"));
            for (String line : welcome){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}