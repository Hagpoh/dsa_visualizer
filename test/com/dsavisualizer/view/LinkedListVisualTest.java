package com.dsavisualizer.view;

import com.dsavisualizer.view.LinkedListVisual;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class LinkedListVisualTest
{
    LinkedListVisual visual;
    LinkedList<Integer> list;

    @Before
    public void setUp()
    {
        list = new LinkedList<>();
        visual = new LinkedListVisual(list);
    }


    @Test
    public void name()
    {
    }
}