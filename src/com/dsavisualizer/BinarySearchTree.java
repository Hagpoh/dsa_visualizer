package com.dsavisualizer;


import java.util.Vector;

public class BinarySearchTree implements DataStructure
{
    //Fields--------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public Node root;


    //Constructors--------------------------------------------------------------
    //--------------------------------------------------------------------------
    public BinarySearchTree()
    {
        root = null;
    }
    public BinarySearchTree(int value)
    {
        root = new Node(value);
    }

    //Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public boolean isEmpty()
    {
        if (root == null)
            return true;
        return false;
    }
    public void balance()
    {
        // Store nodes of given BST in sorted order
        Vector<Node> nodes = new Vector<Node>();
        storeBSTNodes(root, nodes);

        // Constructs BST from nodes[]
        int n = this.size();
        this.root = buildTreeUtil(nodes, 0, n - 1);
    }
    private void storeBSTNodes(Node root, Vector<Node> nodes)
    {
        // Base case
        if (root == null)
            return;

        // Store nodes in Inorder (which is sorted
        // order for BST)
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }
    private Node buildTreeUtil(Vector<Node> nodes, int start, int end)
    {
        // base case
        if (start > end)
            return null;

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        /* Using index in Inorder traversal, construct
           left and right subtress */
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }

    public int size()
    {
        //PREORDER TRAVERSAL TO GET SIZE
        int count = 0;

        count = size(this.root, count);

        return count;
    }

    private int size(Node root, int count)
    {
        int counter = count;
        if (root != null)
        {
            counter++;
            counter = size(root.left, counter);
            counter = size(root.right, counter);
        }
        return counter;
    }

    // Calls the insertRec method passing in root node and provided key
    public void insert(int key)
    {
        root = insertRec(root, key);
        balance();
    }
    public void insert(Node node)
    {
        root = insertRec(root, node.key);
    }

    private Node insertRec(Node root, int key)
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
    public String inorder()
    {
        StringBuilder tree = new StringBuilder("[ ");
        tree.append(inorderRec(root));
        tree.append("]");
        return tree.toString();
    }
    public String preorder()
    {
        StringBuilder tree = new StringBuilder("[ ");
        tree.append(preorderRec(root));
        tree.append("]");
        return tree.toString();
    }

    // Preorder traversal of BST
    private String preorderRec(Node node)
    {
        StringBuilder tree = new StringBuilder();
        if (node != null)
        {
            tree.append(node.key + " ");
            tree.append(preorderRec(node.left));
            tree.append(preorderRec(node.right));
        }
        return tree.toString();
    }

    // Inorder traversal of BST
    private String inorderRec(Node root)
    {
        StringBuilder tree = new StringBuilder();

        if (root != null)
        {
            tree.append(inorderRec(root.left));
            tree.append(root.key + " ");
            tree.append(inorderRec(root.right));
        }

        return tree.toString();
    }
    public boolean contains(int key)
    {
        return containsRec(root, key);
    }
    private boolean containsRec(Node root, int key)
    {
        if (root == null || (root.key != key && branchIsEmpty(root)))
            return false;
        else if (root.key == key)
        {
            return true;
        }
        if (root.key < key)
            return containsRec(root.right, key);
        else
            return containsRec(root.left, key);
    }

    //Getters & Setters---------------------------------------------------------
    //--------------------------------------------------------------------------
    public static boolean branchIsEmpty(Node node)
    {
        if (node == null || node.left == null && node.right == null)
            return true;
        return false;
    }
    public int getRootKey()
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


    //INNER CLASSES-------------------------------------------------------------
    //--------------------------------------------------------------------------
    //Node class setting up a basic node
    public static class Node
    {
        public int key;
        public Node left, right;

        public Node(int key)
        {
            this.key = key;
        }
    }
}
