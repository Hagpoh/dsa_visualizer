package com.dsavisualizer;

import java.util.LinkedList;

public class LinkedListVisual implements Visualizer {

    LinkedList<Integer> list;

    public LinkedListVisual(LinkedList<Integer> list) {
        this.list = list;
    }

    public boolean search(int searchValue) {
        for (Integer item : list) {
            System.out.print(item + " --> ");
        }
        System.out.print("\n");
        for (Integer item : list) {
            try {
                if (!item.equals(searchValue)) {
                    System.out.print(Color.RED.getColor() + item + " --> ");
                    Thread.sleep(1000);
                } else {
                    System.out.print(Color.GREEN.getColor() + item + " ");
                    System.out.println("Value found!");
                    return true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Value not found!");
        return false;
    }

    public void add(int index, int value) {
        list.add(index, value);
        int count = 0;

        for (int i = 0; i < index; i++) {
            String out = list.get(i) + " --> ";
            count += out.length();
            System.out.print(out);
        }

        for (int i = index + 1; i < list.size(); i++) {
            String out = list.get(i) + " --> ";
            System.out.print(out);
        }

        count += 1;
        System.out.println();
        String line1 = Color.GREEN.getColor() + (" ").repeat(count) + "\\ " + " /\n";
        System.out.print(line1);
        String line2 = (" ").repeat(count) + " \\" + "/ \n";
        System.out.print(line2);
        System.out.println((" ").repeat(count + 1) + value);

        for (Integer integer : list) {
            String out = Color.DEFAULT.getColor() + integer + " --> ";
            System.out.print(out);
        }
    }

    public void sort() {

    }
}