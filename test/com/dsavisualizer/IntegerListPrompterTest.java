package com.dsavisualizer;

import org.junit.Before;

import java.util.List;

public class IntegerListPrompter
{
    IntegerListPrompter prompter;
    List<Integer> list;

    @Before
    public void setUp() throws Exception
    {
        prompter = IntegerListPrompter.newInstance(list, 2);
    }



}