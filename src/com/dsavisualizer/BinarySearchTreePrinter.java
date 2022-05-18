package com.dsavisualizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTreePrinter {


}

//Node class setting up a basic node
class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
    }
}

//Algorithms to run on Binary Search Tree
class BinarySearchTree {

    public Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int value) {
        root = new Node(value);
    }

    // Calls the insertRec method passing in root node and provided key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        // Check tree to see if empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Recursive calls down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Call inorderRec passing in root node
    public void inorder() {
        inorderRec(root);
    }

    public void preorder() {
        preorderRec(root);
    }

    // Preorder traversal of BST
    public void preorderRec(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    // Inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    //Getters & Setters---------------------------------------------------------
    //--------------------------------------------------------------------------
    public static boolean branchIsEmpty(Node node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    public int getKey() {
        return this.root.key;
    }

    public static Node getLeftNode(Node node) {
        return node.left;
    }

    public static Node getRightNode(Node node) {

        return node.right;
    }
}

//Prints the tree to the console in a visualizable view
class BTreePrinter {

    public static void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}