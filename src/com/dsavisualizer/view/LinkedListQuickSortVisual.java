package com.dsavisualizer.view;


import com.dsavisualizer.app.Color;

//TODO: Integrate this code into the LinkedListVisual Code as an inner class
//TODO: specify that this is a sort that only performs natural ordering sort to show the implementation of the algorithm
//      In the builtin implementation, we can use any data structure as a list with a given comparator class
public class LinkedListQuickSortVisual
{
    static class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            this.data = d;
            this.next = null;
        }
    }

    Node head;

    void addNode(int data)
    {
        if (head == null)
        {
            head = new Node(data);
            return;
        }

        Node curr = head;
        while (curr.next != null)
            curr = curr.next;

        Node newNode = new Node(data);
        curr.next = newNode;
    }

    int size()
    {
        int count = 0;

        Node n = this.head;

        while (n != null)
        {
            count++;
            n = n.next;
        }

        return count;
    }

    void printList(Node g)
    {
        System.out.print("head --> ");

        Node n = this.head;

        while (n != null)
        {
            if (g == n)
                System.out.print(Color.RED.getColor()+n.data+Color.DEFAULT.getColor());
            else
                System.out.print(n.data);

            System.out.print(" --> ");
            n = n.next;
        }
        System.out.print( "null\n");
    }

    void printList(Node n, Node marker1, Node marker2)
    {
        System.out.print("head --> ");

        while (n != null)
        {
            //TODO: repeating sout statements.. make a new method for this
            if(marker1 == n && n == marker2)
                System.out.print(Color.BLUE.getColor() + n.data + Color.DEFAULT.getColor());
            else if(n == marker1)
                System.out.print(Color.RED.getColor() + n.data + Color.DEFAULT.getColor());
            else if(marker2 == n)
                System.out.print(Color.GREEN.getColor() + n.data + Color.DEFAULT.getColor());
            else
                System.out.print(n.data);
            System.out.print(" --> ");
            n = n.next;
        }

        System.out.print( "null\n");
    }

    void printList(Node N, Node end)
    {


        Node n = this.head;

        System.out.print("head --> ");

        while (n != null)
        {
            if(n == end || N == n)
                System.out.print(Color.BLUE.getColor() + n.data + Color.DEFAULT.getColor());
            else
                System.out.print(n.data);
            System.out.print(" --> ");
            n = n.next;

        }

        System.out.print( "null\n");
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
                System.out.format("Check: The node %d is less than the pivot node %d\n\n",  start.data, pivot);
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;

            }
            else
            {

                System.out.format("Check: The node %d is greater than the pivot node %d\n\n",  start.data, pivot);
                break;
            }
            start = start.next;
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        if(curr.data != end.data)
        {
            System.out.format("Because %d is less than %d, their positions will be swapped\n", end.data, curr.data);
            printList(end);
        }

        if(curr.data == pivot && pivot ==end.data)
            System.out.println(Color.BLUE.getColor()+"This node is in the right position"+ Color.DEFAULT.getColor());

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

    void sort(Node start, Node end)
    {
        if (start == null || start == end || start == end.next) return;


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