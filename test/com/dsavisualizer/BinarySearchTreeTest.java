package com.dsavisualizer;

import org.junit.Before;
import org.junit.Test;

import static com.dsavisualizer.BinarySearchTree.*;
import static org.junit.Assert.*;

public class BinarySearchTreeTest
{
    //Test Fields---------------------------------------------------------------
    //--------------------------------------------------------------------------
    BinarySearchTree tree;

    //setUp---------------------------------------------------------------------
    //--------------------------------------------------------------------------
    @Before
    public void setUp()
    {
        tree = new BinarySearchTree();
    }

    //Test Methods--------------------------------------------------------------
    //--------------------------------------------------------------------------

    @Test
    public void emptyTree_isEmptyTest_shouldReturnTrue()
    {
        assertTrue(tree.isEmpty());
    }

    @Test
    public void nonEmptyTree_isEmptyTest_shouldReturnFalse()
    {
        tree.insert(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void branchWith1LeftChildNode_branchIsEmptyTest_ShouldReturnFalse()
    {
        tree.insert(1);
        tree.root.left = new Node(1);

        assertFalse(branchIsEmpty(tree.root));
    }

    @Test
    public void branchWith1RightChildNode_branchIsEmptyTest_ShouldReturnFalse()
    {
        tree.insert(1);
        tree.root.right = new Node(1);

        assertFalse(branchIsEmpty(tree.root));
    }

    @Test
    public void branchWith2ChildrenNodes_branchIsEmptyTest_ShouldReturnFalse()
    {
        tree.insert(1);
        tree.root.left = new Node(2);


        assertFalse(branchIsEmpty(tree.root));
    }

    @Test
    public void branchWithNoChildrenNodes_branchIsEmptyTest_ShouldReturnFalse()
    {
        tree.insert(1);

        assertTrue(branchIsEmpty(tree.root));
    }

    @Test
    public void insertOf2Nodes_shouldPlaceNodeInProperSideOfRootNode()
    {
        tree.insert(2);
        tree.insert(1);

        assertEquals(tree.root.key,2);
        assertEquals(tree.root.right.key, 1);
    }

    @Test
    public void getKeyShouldReturnProperValueOfTheCurrentNode()
    {
        tree.insert(1);
        tree.root.right = new Node(2);

        assertEquals(1, tree.getKey());
        //TODO: how to test right node??
    }

    @Test
    public void getRightNodeShouldReturnTheCurrentRightNode()
    {
        tree.insert(2);
        tree.root.right = new Node(3);

        assertEquals(tree.root.right, getRightNode(tree.root));
    }
    @Test
    public void getLeftNodeShouldReturnTheCurrentLeftNode()
    {
        tree.insert(2);
        tree.root.left = new Node(3);

        assertEquals(tree.root.left, getLeftNode(tree.root));
    }

    @Test
    public void insertDoesNotAllowDuplicateValuesInTree_shouldReturnTreeOfSize1AfterMultipleInsertsOfSameValue()
    {
        tree.insert(1);
        tree.insert(1);
        tree.insert(1);
        tree.insert(1);
        tree.insert(1);

        assertEquals(1, tree.size());


    }

    @Test
    public void treeSizeOf3_After3ValidInsertsAreInput()
    {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);


        assertEquals(3,tree.size());
    }
    @Test
    public void treeSizeOf10_After10ValidInsertsAreInput()
    {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(2);
        tree.insert(6);
        tree.insert(9);
        tree.insert(10);


        assertEquals(10,tree.size());
    }

    @Test
    public void emptyTree_shouldShowSizeOfZero()
    {
        assertEquals(0, tree.size());
    }

    @Test
    public void containsMethodShouldReturnTrueForValuesInTree()
    {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(2);
        tree.insert(6);
        tree.insert(9);
        tree.insert(10);

        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(9));
        assertTrue(tree.contains(10));
    }

    @Test
    public void containsMethodShouldReturnFalseForValuesNotInTree()
    {
        tree.insert(0);
        assertFalse(tree.contains(1));
        assertFalse(tree.contains(2));
        assertFalse(tree.contains(3));
        assertFalse(tree.contains(4));
        assertFalse(tree.contains(5));
        assertFalse(tree.contains(6));
        assertFalse(tree.contains(7));
        assertFalse(tree.contains(8));
        assertFalse(tree.contains(9));
        assertFalse(tree.contains(10));
    }

    @Test
    public void treeOf3Nodes_BalanceAfterUnbalancedInsertTest_shouldReturnProperInOrderTraversal()
    {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertEquals("[2 1 3 ]", tree.inorder());
    }
}