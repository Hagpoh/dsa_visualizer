package com.dsavisualizer.view;

import com.dsavisualizer.BinarySearchTree;
import com.dsavisualizer.BinarySearchTree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private BinarySearchTreeVisual(BinarySearchTree bst)
    {
        this.bst = bst;
    }

    public static BinarySearchTreeVisual newInstance(BinarySearchTree bst)
    {
        return new BinarySearchTreeVisual(bst);
    }
    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    @Override
    public boolean search(int searchValue)
    {
        //BASE CASES-----------------------------------
        //tree is empty
        if (branchIsEmpty(bst.root))
        {
            System.out.println("Tree is empty");
            return VALUE_NOT_FOUND;
        } else if (bst.getKey() == searchValue)
        {
            System.out.println("Found!");
            return VALUE_FOUND;
        }
        //----------------------------------------------

        else if (bst.getKey() < searchValue)
        {
            BinarySearchTree.Node leftNode = getLeftNode(this.bst.root);
            printTree(leftNode, !VERBOSE_TREE);
            return search(leftNode, searchValue);
        } else //bst.getLeftNodeValue() > search
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
        if (branchIsEmpty(node))
        {
            System.out.println("NOT FOUND");
            return VALUE_NOT_FOUND;
        } else if (bst.getKey() == searchValue)
        {
            System.out.println("Found!");
            return VALUE_FOUND;
        }
        //----------------------------------------------

        else if (bst.getKey() < searchValue)
        {
            BinarySearchTree.Node leftNode = getLeftNode(node);
            printTree(leftNode, !VERBOSE_TREE);
            return search(getLeftNode(node), searchValue);
        } else // (bst.getLeftNodeValue() > search)
        {
            BinarySearchTree.Node leftNode = getLeftNode(node);
            printTree(leftNode, !VERBOSE_TREE);
            return search(getRightNode(node), searchValue);
        }

    }

    public void addNode(int nodeValue)
    {
        bst.insert(nodeValue);
    }


    private void printTree(BinarySearchTree.Node root, boolean printCompleteTree)
    {
        System.out.println();

        if (printCompleteTree)
        {
            //TODO: print whole tree
            //TODO: print "root" node red and all other nodes default
            // THIS DOES NOT NEED TO BE THE ROOT NODE BUT THE root THAT'S PASSED IN
            printNode(bst.root);
        }

        //else only print subtree of this node and the children nodes
        //TODO:print the current node red and the other nodes default
        printNode(root);

        System.out.println();
    }


    //Prints the tree to the console in a visualizable view
    //--------------------------------------------------------------------------

    public static void printNode(Node root)
    {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node> nodes, int level, int maxLevel)
    {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes)
        {
            if (node != null)
            {
                System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else
            {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++)
        {
            for (int j = 0; j < nodes.size(); j++)
            {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null)
                {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count)
    {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Node node)
    {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list)
    {
        for (Object object : list)
        {
            if (object != null)
                return false;
        }

        return true;
    }
}