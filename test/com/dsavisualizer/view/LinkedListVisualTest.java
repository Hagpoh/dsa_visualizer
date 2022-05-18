package com.dsavisualizer.view;

import com.dsavisualizer.view.LinkedListVisual;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class LinkedListVisualTest {
    LinkedListVisual visual;
    LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedList<>();
        visual = new LinkedListVisual(list);
    }


    @Test
    public void name() {
    }
}