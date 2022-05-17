package com.dsavisualizer;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class IntegerListPrompterTest
{
    private IntegerListPrompter prompter;
    private LinkedList<Integer> list;
    private final int VALID_NEEDED_VALUE_FOR_PROMPTER = 2;
    private final int INVALID_NEEDED_VALUE_FOR_PROMPTER = 0;

    @Before
    public void setUp() throws Exception
    {
        list = new LinkedList<>();
        prompter = IntegerListPrompter.newInstance(list, VALID_NEEDED_VALUE_FOR_PROMPTER);
    }

    @Test
    public void creatingIntegerListPrompter_InvalidConstructorArgumentsPassed_ShouldThrowIllegalArgumentException()
    {
        list = new LinkedList<>();

        list.add(1);

        //testing valid "valueNeeded" argument and invalid List argument
        assertThrows(new IllegalArgumentException().getClass(), () -> IntegerListPrompter.newInstance(list, VALID_NEEDED_VALUE_FOR_PROMPTER));

        list = new LinkedList<>();
        
        //testing invalid "valueNeeded" argument and valid List argument
        assertThrows(new IllegalArgumentException().getClass(), () -> IntegerListPrompter.newInstance(list, INVALID_NEEDED_VALUE_FOR_PROMPTER));
    }



    @Test
    public void listAfterAdding_ReflectsNewAdditions()
    {
        LinkedList<Integer> MatchingList = new LinkedList<Integer>();
        MatchingList.add(1);
        MatchingList.add(2);

        String input1 = "1";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);
        prompter.add();

        assertEquals(Arrays.toString(MatchingList.stream().toArray()), Arrays.toString(prompter.getIntegerList().stream().toArray()));
    }


    //TODO: do more to test these methods below---------------------------------
    //--------------------------------------------------------------------------
    @Test
    public void validArgumentsPassed_IntegerList()
    {
        IntegerListPrompter.newInstance(list, VALID_NEEDED_VALUE_FOR_PROMPTER);
    }
}