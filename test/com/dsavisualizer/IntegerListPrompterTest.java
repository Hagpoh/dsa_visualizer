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
    public void listAfterAddingInvalidValues_shouldHaveOnlyValidNumbers()
    {
        LinkedList<Integer> MatchingList = new LinkedList<Integer>();
        MatchingList.add(2);
        MatchingList.add(1);
        MatchingList.add(3);

        String input = "2,q,899,1,e,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        prompter.add();

        assertEquals(Arrays.toString(MatchingList.stream().toArray()), Arrays.toString(prompter.getIntegerList().stream().toArray()));
    }

    @Test
    public void listAfterAddingDuplicateValues_ShouldHaveUniqueValues()
    {
        LinkedList<Integer> MatchingList = new LinkedList<Integer>();
        MatchingList.add(2);
        MatchingList.add(1);
        MatchingList.add(3);

        String input = "2,1,3,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        prompter.add();

        assertEquals(Arrays.toString(MatchingList.stream().toArray()), Arrays.toString(prompter.getIntegerList().stream().toArray()));
    }

    @Test
    public void listAfterAdding_ReflectsNewAdditions()
    {
        LinkedList<Integer> MatchingList = new LinkedList<Integer>();
        MatchingList.add(2);
        MatchingList.add(1);
        MatchingList.add(3);

        String input = "2,1,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        prompter.add();

        assertEquals(Arrays.toString(MatchingList.stream().toArray()), Arrays.toString(prompter.getIntegerList().stream().toArray()));
    }

    @Test
    public void listAfterNotAddingEnoughValues_ShouldKeepRequestingMoreValues()
    {
        LinkedList<Integer> MatchingList = new LinkedList<Integer>();
        MatchingList.add(2);
        MatchingList.add(1);
        MatchingList.add(3);

        String input = "2,1,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        prompter.add(false);

        assertEquals(Arrays.toString(MatchingList.stream().toArray()), Arrays.toString(prompter.getIntegerList().stream().toArray()));
    }

    @Test
    public void listAfterNotAddingEnoughValue_ThenMeetingTheQuota_ShouldGiveTheCompleteList_withoutAddingDuplicateValue()
    {
        //place holder
        assertFalse(true);
        //TODO:find a way to read in next line to test this code below
//        LinkedList<Integer> MatchingList = new LinkedList<Integer>();
//        MatchingList.add(2);
//        MatchingList.add(3);
//
//        String input = "2\n3,2";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        prompter.add();
//
//        assertEquals(Arrays.toString(MatchingList.stream().toArray()), Arrays.toString(prompter.getIntegerList().stream().toArray()));
    }

    //TODO: do more to test these methods below---------------------------------
    //--------------------------------------------------------------------------
    @Test
    public void validArgumentsPassed_IntegerList()
    {
        IntegerListPrompter.newInstance(list, VALID_NEEDED_VALUE_FOR_PROMPTER);
    }
}