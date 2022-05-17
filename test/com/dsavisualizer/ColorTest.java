package com.dsavisualizer;

import com.dsavisualizer.app.Color;
import com.dsavisualizer.app.Color;
import org.junit.Before;
import org.junit.Test;

public class ColorTest
{
    //TODO: Find a way to automate
    // Could run into issue with colorblind people
    @Before
    public void setUp() throws Exception
    {
        System.out.println("below is a manual visual test.");
    }

    @Test
    public void greenColorTest_shouldOutputStringInGreen()
    {
        System.out.println(Color.GREEN.getColor() + "This is green." + Color.DEFAULT.getColor());
    }


    @Test
    public void blueColorTest_shouldOutputStringInBlue()
    {
        System.out.println(Color.BLUE.getColor() + "This is blue."+ Color.DEFAULT.getColor());
    }


    @Test
    public void redColorTest_shouldOutputStringInRed()
    {
        System.out.println(Color.RED.getColor() + "This is red."+ Color.DEFAULT.getColor());
    }


    @Test
    public void YellowColorTest_shouldOutputStringInYellow()
    {
        System.out.println(Color.YELLOW.getColor() + "This is yellow."+ Color.DEFAULT.getColor());
    }


    @Test
    public void defaultColorTest_shouldOutputStringInDefault()
    {
        System.out.println(Color.RED.getColor() + "This is should change back "+ Color.DEFAULT.getColor()+ "halfway to default color (Usually white/black).");
    }
}