package com.dsavisualizer;

import com.dsavisualizer.app.Color;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

//TODO: remove magic numbers in this class
//TODO: organize class into normal conventions

public class LinkedList implements DataStructure
{
    //CLASS FIELDS--------------------------------------------------------------
    //--------------------------------------------------------------------------
    public Node head;

    //Constructor---------------------------------------------------------------
    //--------------------------------------------------------------------------
    //TODO:Need constructor????


    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public Node lastNode()
    {
        Node node = head;
        for (int i = 0; i < size(); i++)
        {
            if(node.next != null)
                node = node.next;
        }
        return node;
    }

    public void addNode(int data)
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

    Node paritionLast(Node start, Node end)
    {
        if (start == end || start == null || end == null)
            return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;


        while (start != end)
        {
            if (start.data < pivot)
            {
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;


        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    public void sort(Node start, Node end)
    {
        if (start == null || start == end || start == end.next) return;


        // split list and partition recurse
        Node pivot_prev = paritionLast(start, end);
        sort(start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);

            // if pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }

    public void addNode(int index, int value)
    {
        Node node = this.head;
        for (int i = 0; i < index; i++)
            node = node.next;

        Node newNode = new Node(value);
        newNode.next = node.next;

        node.next = newNode;
    }

    //Getters & Setters---------------------------------------------------------
    //--------------------------------------------------------------------------
    public boolean isEmpty()
    {
        return (size() == 0) ? true : false;
    }

    public int get(int index)
    {
        if ((index < 0 || index >= this.size()))
            throw new IndexOutOfBoundsException();

        Node current = this.head;

        int counter = 0;
        while (counter < index)
        {
            counter++;
            current = current.next;
        }

        return current.data;
    }

    public boolean contains(int searchValue)
    {
        int sizeOfList = this.size();
        Node node = this.head;
        for (int i = 0; i < sizeOfList; i++)
        {
            if (node.data == searchValue)
                return true;
            node = node.next;
        }
        return false;
    }

    public int size()
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

    @Override
    public String toString()// Used mainly for test
    {
        StringBuilder list = new StringBuilder();

        list.append("[ ");
        for (int i = 0; i < this.size(); i++)
        {
            list.append(this.get(i));
        }

        list.append(" ]");

        return list.toString();
    }

    //INNER CLASS---------------------------------------------------------------
    //--------------------------------------------------------------------------
    public static class Node
    {
        public int data;
        public Node next;

        Node(int d)
        {
            this.data = d;
            this.next = null;
        }
    }
}