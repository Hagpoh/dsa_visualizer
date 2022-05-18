package com.dsavisualizer.view;

import com.dsavisualizer.BinarySearchTree;
import static com.dsavisualizer.BinarySearchTree.branchIsEmpty;
import static com.dsavisualizer.BinarySearchTree.getLeftNode;
import static com.dsavisualizer.BinarySearchTree.getRightNode;

public class BinarySearchTreeVisual implements Visualizer
{
    //CLASS FIELDS--------------------------------------------------------------
    //--------------------------------------------------------------------------
    private BinarySearchTree bst = new BinarySearchTree();
    private final Boolean VERBOSE_TREE = true;
    private final Boolean VALUE_FOUND = true;
    private final Boolean VALUE_NOT_FOUND = false;

    //Constructor---------------------------------------------------------------
    //--------------------------------------------------------------------------


    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    @Override
    public boolean search(int searchValue)
    {
        //BASE CASES-----------------------------------
        //tree is empty
        if(branchIsEmpty(bst.root))
        {
            System.out.println("Tree is empty");
            return VALUE_NOT_FOUND;
        }
        else if(bst.getKey() == searchValue)
        {
            System.out.println("Found!");
            return VALUE_FOUND;
        }
        //----------------------------------------------

        else if(bst.getKey() < searchValue)
        {
            BinarySearchTree.Node leftNode = getLeftNode(this.bst.root);
            printTree(leftNode, !VERBOSE_TREE);
            return search(leftNode, searchValue);
        }
        else //bst.getLeftNodeValue() > search
        {
            BinarySearchTree.Node rightNode = getRightNode(this.bst.root);
            printTree(rightNode, !VERBOSE_TREE);
            return search(rightNode, searchValue);
        }
    }
    //Recursive helper method
    public boolean search(BinarySearchTree.Node node, int searchValue)
    {
        //BASE CASES-----------------------------------
        //tree is empty
        if(branchIsEmpty(node))
        {
            System.out.println("NOT FOUND");
            return VALUE_NOT_FOUND;
        }
        else if(bst.getKey() == searchValue)
        {
            System.out.println("Found!");
            return VALUE_FOUND;
        }
        //----------------------------------------------

        else if(bst.getKey() < searchValue)
        {
            BinarySearchTree.Node leftNode = bst.getLeftNode(node);
            printTree(leftNode, !VERBOSE_TREE);
            return search(getLeftNode(node), searchValue);
        }

        else // (bst.getLeftNodeValue() > search)
        {
            BinarySearchTree.Node leftNode = bst.getLeftNode(node);
            printTree(leftNode, !VERBOSE_TREE);
            return search(getRightNode(node), searchValue);
        }

    }

    public void addNode(int nodeValue)
    {
        bst.insert(nodeValue);
        printTree();
    }


    private void printTree(BinarySearchTree.Node root, boolean printCompleteTree)
    {
        System.out.println();

        if(printCompleteTree)
        {
            //TODO: print whole tree
            //TODO: print "root" node red and all other nodes default
            // THIS DOES NOT NEED TO BE THE ROOT NODE BUT THE root THAT'S PASSED IN
        }

        //else only print subtree of this node and the children nodes
        //TODO:print the current node red and the other nodes default


        System.out.println();
    }
}