package com.dsavisualizer.view;

import com.dsavisualizer.app.Color;
import com.dsavisualizer.view.Visualizer;

import java.util.LinkedList;

public class LinkedListVisual implements Visualizer {

    LinkedList<Integer> list;

    public LinkedListVisual(LinkedList<Integer> list) { //Constructor for the Linked List you want to visualize
        this.list = list;
    }
    //Visualizes a search by traversing a linked list
    public boolean search(int searchValue) {
        for (int i = 0; i < list.size(); i++) { //Print arrows to show the linked list
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            }
            if (i < list.size() - 1) {
                System.out.print(list.get(i) + " --> ");
            }
        }
        System.out.print("\n");
        for (Integer item : list) { //Slowly prints the list in order searching for inputted search value
            try {
                if (!item.equals(searchValue)) {
                    System.out.print(Color.RED.getColor() + item + " --> ");
                    Thread.sleep(1500);
                } else {
                    System.out.print(Color.GREEN.getColor() + item + " ");
                    System.out.println("Value found!" + Color.DEFAULT.getColor()); //When the value is found
                    return true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Value not found!" + Color.DEFAULT.getColor()); //When the value is not found
        return false;
    }

    //Visualizes the add by changing pointers
    public void add(int index, int value) {
        list.add(index, value);
        int count = 0; //count to keep track of spaces

        //Loop for before the insertion index
        for (int i = 0; i < index; i++) {
            String out = null;
            if (i == index - 1) {
                out = list.get(i) + Color.RED.getColor() + " --> " + Color.DEFAULT.getColor();
            }
            if (i < index - 1) {
                out = list.get(i) + " --> ";
            }
            if (out != null) {
                count += out.length();
                System.out.print(out);
            }
        }

        //Loop for after the insertion index
        for (int i = index + 1; i < list.size(); i++) {
            String out = null;
            if (i == list.size() - 1) {
                out = list.get(i).toString();
            }
            if (i < list.size() - 1) {
                out = list.get(i) + " --> ";
            }
            if (out != null) {
                System.out.print(out);
            }
        }

        //Shows the insertion value with the slashes pointing
        count -= (Color.RED.getColor() + " --> " + Color.DEFAULT.getColor()).length();
        System.out.println();
        String line1 = Color.GREEN.getColor() + (" ").repeat(count) + "\\ " + " /\n";
        System.out.print(line1);
        String line2 = (" ").repeat(count) + " \\" + "/ \n";
        System.out.print(line2);
        System.out.println((" ").repeat(count + 1) + value + Color.DEFAULT.getColor());
    }

    public void sort() {

    }
}