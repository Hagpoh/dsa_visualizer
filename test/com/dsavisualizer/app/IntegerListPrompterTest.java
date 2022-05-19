package com.dsavisualizer.app;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import com.dsavisualizer.LinkedList;

import static org.junit.Assert.*;

public class IntegerListPrompterTest
{
    //Test Fields---------------------------------------------------------------
    //--------------------------------------------------------------------------
    private IntegerListPrompter prompter;
    private LinkedList list;
    private final int VALID_NEEDED_VALUE_FOR_PROMPTER = 2;
    private final int INVALID_NEEDED_VALUE_FOR_PROMPTER = 0;

    //setUp--------------------------------------------------------------------
    //--------------------------------------------------------------------------
    @Before
    public void setUp()
    {
        list = new LinkedList();
        prompter = IntegerListPrompter.newInstance(list, VALID_NEEDED_VALUE_FOR_PROMPTER);
    }

    //Test Methods--------------------------------------------------------------
    //--------------------------------------------------------------------------
    @Test
    public void creatingIntegerListPrompter_InvalidConstructorArgumentsPassed_ShouldThrowIllegalArgumentException()
    {
        list = new LinkedList();

        list.addNode(1);

        //testing valid "valueNeeded" argument and invalid List argument
        assertThrows(new IllegalArgumentException().getClass(), () -> IntegerListPrompter.newInstance(list, VALID_NEEDED_VALUE_FOR_PROMPTER));

        list = new LinkedList();

        //testing invalid "valueNeeded" argument and valid List argument
        assertThrows(new IllegalArgumentException().getClass(), () -> IntegerListPrompter.newInstance(list, INVALID_NEEDED_VALUE_FOR_PROMPTER));
    }

    @Test
    public void listAfterAddingInvalidValues_shouldHaveOnlyValidNumbers()
    {
        LinkedList MatchingList = new LinkedList();
        MatchingList.addNode(2);
        MatchingList.addNode(1);
        MatchingList.addNode(3);

        String input = "2,q,899,1,e,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        prompter.add();

        assertEquals(MatchingList.toString(), prompter.getIntegerList().toString());
    }

    @Test
    public void listAfterAddingDuplicateValues_ShouldHaveUniqueValues()
    {
        LinkedList MatchingList = new LinkedList();
        MatchingList.addNode(2);
        MatchingList.addNode(1);
        MatchingList.addNode(3);

        String input = "2,1,3,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        prompter.add();

        assertEquals(MatchingList.toString(), prompter.getIntegerList().toString());
    }

    @Test
    public void listAfterAdding_ReflectsNewAdditions()
    {
        LinkedList MatchingList = new LinkedList();
        MatchingList.addNode(2);
        MatchingList.addNode(1);
        MatchingList.addNode(3);

        String input = "2,1,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        prompter.add();

        assertEquals(MatchingList.toString(), prompter.getIntegerList().toString());
    }

    @Test
    public void listAfterNotAddingEnoughValues_ShouldKeepRequestingMoreValues()
    {
        LinkedList MatchingList = new LinkedList();
        MatchingList.addNode(2);
        MatchingList.addNode(1);
        MatchingList.addNode(3);

        String input = "2,1,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        prompter.add(false);

        assertEquals(MatchingList.toString(), prompter.getIntegerList().toString());
    }

    @Test
    public void listAfterNotAddingEnoughValue_ThenMeetingTheQuota_ShouldGiveTheCompleteList_withoutAddingDuplicateValue()
    {
        //place holder
        assertFalse(true);
        //TODO:find a way to read in next line to test this code below
//        LinkedList MatchingList = new LinkedList();
//        MatchingList.addNode(2);
//        MatchingList.addNode(3);
//
//        String input = "2\n3,2";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        prompter.addNode();
//
//        assertEquals(MatchingList.toString(), prompter.getIntegerList().toString());
    }

    //TODO: do more to test these methods below---------------------------------
    //--------------------------------------------------------------------------
    @Test
    public void validArgumentsPassed_IntegerList()
    {
        IntegerListPrompter.newInstance(list, VALID_NEEDED_VALUE_FOR_PROMPTER);
    }
}