package com.dsavisualizer.app;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class VisualizeAppTest
{
    VisualizeApp app;
    Scanner scanner ;

    @Before
    public void setUp()
    {
        app =     new VisualizeApp();
        scanner = new Scanner(System.in);
    }

    @Test
    public void validInputAtDataStructurePrompt_shouldReturn()
    {

    }

    @Test
    public void validInputAtAlgorithmPrompt_shouldReturn()
    {

    }
}