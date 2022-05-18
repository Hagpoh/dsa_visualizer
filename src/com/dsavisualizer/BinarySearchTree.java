package com.dsavisualizer;

public class BinarySearchTree
{

    //Node class setting up a basic node
    public class Node
    {
        private int key;
        private Node left, right;

        public Node(int item)
        {
            key = item;
            left = null;
            right = null;
        }
    }

    public Node root;

    // Constructor
    public BinarySearchTree()
    {
        root = null;
    }

    BinarySearchTree(int value)
    {
        root = new Node(value);
    }

    // Calls the insertRec method passing in root node and provided key
    public void insert(int key)
    {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key)
    {
        // Check tree to see if empty
        if (root == null)
        {
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
    public void inorder()
    {
        inorderRec(root);
    }

    public void preorder()
    {
        preorderRec(root);
    }

    // Preorder traversal of BST
    public void preorderRec(Node node)
    {
        if (node != null)
        {
            System.out.println(node.key);
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    // Inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    //Getters & Setters---------------------------------------------------------
    //--------------------------------------------------------------------------
    public static boolean branchIsEmpty(Node node)
    {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    public int getKey()
    {
        return this.root.key;
    }

    public static Node getLeftNode(Node node)
    {
        return node.left;
    }

    public static Node getRightNode(Node node)
    {

        return node.right;
    }
}
