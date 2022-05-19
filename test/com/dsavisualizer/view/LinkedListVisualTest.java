package com.dsavisualizer.view;

import org.junit.Before;

import com.dsavisualizer.LinkedList;

public class LinkedListVisualTest
{
    //Test Fields---------------------------------------------------------------
    //--------------------------------------------------------------------------
    LinkedListVisual visual;
    LinkedList list;

    //setUp---------------------------------------------------------------------
    //--------------------------------------------------------------------------
    @Before
    public void setUp()
    {
        list = new LinkedList();
        visual = new LinkedListVisual(list);
    }

    //Test Methods--------------------------------------------------------------
    //--------------------------------------------------------------------------
}