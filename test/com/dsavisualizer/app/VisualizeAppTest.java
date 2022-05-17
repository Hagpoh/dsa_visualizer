package com.dsavisualizer.app;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
    public void validInputAfterDataStructureAndAlgorithmPrompt_shouldReturnInputRightBack()
    {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(Integer.parseInt(input), app.getIntInput());
    }

    @Test
    public void invalidInputAfterDataStructureAndAlgorithmPrompt_shouldReturnZero()
    {
        String input = "e";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(0  , app.getIntInput()); //0 indicates invalid input
        //assertThrows(new NumberFormatException().getClass(), () ->  app.getIntInput());
    }



    //TODO: do more to test these methods below---------------------------------
    //--------------------------------------------------------------------------
    @Test
    public void welcomeHeader_findingFile_shouldNotThrowException()
    {
        app.welcomeHeader();
    }


    //Test currently not needed but may be in the future------------------------
    //--------------------------------------------------------------------------
    @Test
    public void voidMethodThatWritesToConsole_promptForAlgorithm_testNotCurrentlyNeeded()
    {
    }
    @Test
    public void voidMethodThatWritesToConsole_promptForDataStructure_testNotCurrentlyNeeded()
    {
    }
}