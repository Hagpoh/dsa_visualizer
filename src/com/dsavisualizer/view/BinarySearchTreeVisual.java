package com.dsavisualizer.view;

import com.dsavisualizer.BinarySearchTree;
import com.dsavisualizer.BinarySearchTree.Node;
import com.dsavisualizer.app.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.dsavisualizer.BinarySearchTree.branchIsEmpty;
import static com.dsavisualizer.BinarySearchTree.getLeftNode;
import static com.dsavisualizer.BinarySearchTree.getRightNode;

public class BinarySearchTreeVisual implements Searchable,Sortable,Addable
{
    //CLASS FIELDS--------------------------------------------------------------
    //--------------------------------------------------------------------------
    public BinarySearchTree bst;
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
    public boolean search(int searchValue)
    {
        printTree(this.bst.root, VERBOSE_TREE);
        //BASE CASES-----------------------------------
        //tree is empty
        if (branchIsEmpty(bst.root))
        {
            System.out.println("Tree is empty");
            return VALUE_NOT_FOUND;
        } else if (bst.getRootKey() == searchValue)
        {
            System.out.println("Found!");
            return VALUE_FOUND;
        }
        //----------------------------------------------

        else if (bst.getRootKey() > searchValue)
        {
            System.out.println("Cutting search in half");
            System.out.println("Searching left subtree");
            BinarySearchTree.Node leftNode = getLeftNode(this.bst.root);
            printTree(leftNode, !VERBOSE_TREE);
            return search(leftNode, searchValue);
        } else //bst.getLeftNodeValue() < search
        {
            System.out.println("Cutting search in half");
            System.out.println("Searching right subtree");
            BinarySearchTree.Node rightNode = getRightNode(this.bst.root);
            printTree(rightNode, !VERBOSE_TREE);
            return search(rightNode, searchValue);
        }
    }
    //Recursive helper method
    private boolean search(Node node, int searchValue)
    {
        //BASE CASES-----------------------------------
        //tree is empty
        if (node.key != searchValue && (branchIsEmpty(node) || node.key < searchValue && node.right == null || node.key > searchValue && node.left == null))
        {
            System.out.println("NOT FOUND");
            return VALUE_NOT_FOUND;
        } else if (node.key == searchValue)
        {
            System.out.println("Found!");
            return VALUE_FOUND;
        }
        //----------------------------------------------

        else if (node.key < searchValue)
        {
            System.out.println("Cutting search in half");
            System.out.println("Searching right subtree");
            BinarySearchTree.Node rightNode = getRightNode(node);
            printTree(rightNode, !VERBOSE_TREE);
            return search(rightNode, searchValue);
        } else // (bst.getLeftNodeValue() > search)
        {

            System.out.println("Cutting search in half");
            System.out.println("Searching left subtree");
            BinarySearchTree.Node leftNode = getLeftNode(node);
            printTree(leftNode, !VERBOSE_TREE);
            return search(leftNode, searchValue);
        }
    }

    public boolean addNode(int nodeValue)
    {
        if(bst.contains(nodeValue))
        {
            System.out.print("Tree already has value " + nodeValue + ". please try again:");
            return true;
        }
        System.out.println("OLD TREE");
        printTree(this.bst.root, VERBOSE_TREE);
        bst.insert(new Node(nodeValue));
        System.out.print(Color.BLUE.getColor());
        System.out.println("NEW TREE");
        printTree(this.bst.root, VERBOSE_TREE);
        System.out.print(Color.DEFAULT.getColor());
        System.out.println("Tree must be balanced to ensure we maintain fast search speeds.");
        System.out.println("A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.");
        bst.balance();
        System.out.print(Color.GREEN.getColor());
        System.out.println("Tree after balancing");
        printTree(this.bst.root, VERBOSE_TREE);
        System.out.print(Color.DEFAULT.getColor());
        return false;
    }


    public void printTree(Node root, boolean printCompleteTree)
    {
        System.out.println();

        if (printCompleteTree)
        {
            printNode(bst.root);
        }

        //only print subtree of this node and the children nodes
        //TODO:print the current node red and the other nodes default
        else
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

    //Getters & Setters---------------------------------------------------------
    //--------------------------------------------------------------------------
    public Boolean getVERBOSE_TREE()
    {
        return VERBOSE_TREE;
    }
}