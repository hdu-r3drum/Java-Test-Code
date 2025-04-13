package com.dataStructure.AVLTree;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer> t = new AVLTree<>();
        t.insert(3);
        t.insert(2);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        // t.insert(1);
        t.inorder();
        System.out.println(t.treeHeight());
    }
}
