package com.dsavisualizer;

public class BinarySearchTree {

    //Node class setting up a basic node
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = null;
            right = null;
        }
    }

    Node root;

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
}