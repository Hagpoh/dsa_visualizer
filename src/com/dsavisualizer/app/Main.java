package com.dsavisualizer.app;

import com.dsavisualizer.BinarySearchTree;
import com.dsavisualizer.view.BinarySearchTreeVisual;

class Main
{
    public static void main(String[] args)
    {
//        VisualizeApp app = new VisualizeApp();
//        app.execute();

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);

        BinarySearchTreeVisual bstVisual = BinarySearchTreeVisual.newInstance(tree);

        bstVisual.printTree(bstVisual.bst.root, bstVisual.getVERBOSE_TREE());
        bstVisual.search(4);
    }
}