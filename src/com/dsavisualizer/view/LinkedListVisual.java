package com.dsavisualizer.view;

import com.dsavisualizer.app.Color;
import com.dsavisualizer.LinkedList;
import com.dsavisualizer.LinkedList.Node;

public class LinkedListVisual implements Searchable,Sortable,Addable
{
    //Fields--------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public LinkedList list;

    //Constructor---------------------------------------------------------------
    //--------------------------------------------------------------------------
    public LinkedListVisual(LinkedList list)
    { //Constructor for the Linked List you want to visualize
        this.list = list;
    }

    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //Visualizes a search by traversing a linked list
    public boolean search(int searchValue)
    {
        for (int i = 0; i < list.size(); i++)
        { //Print arrows to show the linked list
            if (i == list.size() - 1)
            {
                System.out.print(list.get(i));
            }
            if (i < list.size() - 1)
            {
                System.out.print(list.get(i) + " --> ");
            }
        }
        System.out.print("\n");
        for (int i = 0; i < list.size(); i++)
        { //Slowly prints the list in order searching for inputted search value
            int item = list.get(i);
            try
            {
                if (!(item == searchValue))
                {
                    System.out.print(Color.RED.getColor() + item + " --> ");
                    Thread.sleep(1500);
                } else
                {
                    System.out.print(Color.GREEN.getColor() + item + " ");
                    System.out.println("Value found!" + Color.DEFAULT.getColor()); //When the value is found
                    return true;
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Value not found!" + Color.DEFAULT.getColor()); //When the value is not found
        return false;
    }

    //Visualizes the add by changing pointers
    public void add(int index, int value)
    {
        list.addNode(index, value);
        int count = 0; //count to keep track of spaces

        //Loop for before the insertion index
        for (int i = 0; i < index; i++)
        {
            String out = null;
            if (i == index - 1)
            {
                out = list.get(i) + Color.RED.getColor() + " --> " + Color.DEFAULT.getColor();
            }
            if (i < index - 1)
            {
                out = list.get(i) + " --> ";
            }
            if (out != null)
            {
                count += out.length();
                System.out.print(out);
            }
        }

        //Loop for after the insertion index
        for (int i = index + 1; i < list.size(); i++)
        {
            String out = null;
            if (i == list.size() - 1)
            {
                out = String.valueOf(list.get(i));
            }
            if (i < list.size() - 1)
            {
                out = list.get(i) + " --> ";
            }
            if (out != null)
            {
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

    void printList(Node g)
    {
        System.out.print("head --> ");

        LinkedList.Node n = list.head;

        while (n != null)
        {
            if (g == n)
                System.out.print(Color.RED.getColor() + n.data + Color.DEFAULT.getColor());
            else
                System.out.print(n.data);

            System.out.print(" --> ");
            n = n.next;
        }
        System.out.print("null\n");
    }

    void printList(Node N, Node end)
    {
        Node n = list.head;

        System.out.print("head --> ");

        while (n != null)
        {
            if (n == end || N == n)
                System.out.print(Color.BLUE.getColor() + n.data + Color.DEFAULT.getColor());
            else
                System.out.print(n.data);
            System.out.print(" --> ");
            n = n.next;

        }

        System.out.print("null\n");
    }

    // takes first and last node,
    // but do not break any links in
    // the whole linked list
    Node paritionLast(Node start, Node end)
    {
        if (start == end || start == null || end == null)
            return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;

        System.out.println("\nThe pivot node is " + pivot);

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end)
        {

            if (start.data < pivot)
            {
                // keep tracks of last modified item
                pivot_prev = curr;
                printList(start, end);
                System.out.format("Check: The node %d is less than the pivot node %d\n\n", start.data, pivot);
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;

            } else
            {
                System.out.format("Check: The node %d is greater than the pivot node %d\n\n", start.data, pivot);
            }
            start = start.next;
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        if (curr.data != end.data)
        {
            System.out.format("Because %d is less than %d, their positions will be swapped\n", end.data, curr.data);
            printList(end);
        }

        if (curr.data == pivot && pivot == end.data)
            System.out.println(Color.BLUE.getColor() + "This node is in the right position" + Color.DEFAULT.getColor());

        else
        {
            int temp = curr.data;
            curr.data = pivot;
            end.data = temp;
            printList(end);
        }


        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    public void sort(Node start, Node end)
    {

        if (start == null || start == end || start == end.next)
            return;


        // split list and partition recurse
        Node pivot_prev = paritionLast(start, end);
        sort(start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
        {
            sort(pivot_prev.next, end);
        }

        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null)
        {
            sort(pivot_prev.next.next, end);
        }
    }

    //    public static void main(String[] args)
//    {
//        QuickSort list
//                = new QuickSort();
//        list.addNode(30);
//        list.addNode(24);
//        list.addNode(50);
//        list.addNode(1);
//        list.addNode(266);
//
//        Node n = list.head;
//        while (n.next != null)
//            n = n.next;
//
//        System.out.println("Linked List before sorting");
//        list.printList(list.head);
//
//        list.sort(list.head, n);
//
//        System.out.println("Linked List after sorting");
//        list.printList(list.head);
//    }
}