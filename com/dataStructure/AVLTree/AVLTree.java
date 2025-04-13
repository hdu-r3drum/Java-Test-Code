package com.dataStructure.AVLTree;

public class AVLTree<T extends Comparable<T>> {

    // private int height = 0;

    private Node<T> root;

    class Node<T> {

        int height = 0;
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            // this.parent = parent;
            this.left = left;
            this.right = right;
            height = 1;
        }
    }

    public AVLTree(T value) {
        Node<T> node = new Node<>(value, null, null);
        this.root = node;
    }

    public AVLTree() {
        root = null;
    }

    public void inorder() {
        if (root == null) {
            return;
        }
        Node<T> node = root;
        inorderIteration(node);
    }

    private void inorderIteration(Node<T> node) {
        if(node == null) return;
        if(node.left != null){
            inorderIteration(node.left);
        }
        System.out.print(node.value + " ");
        if(node.right != null){
            inorderIteration(node.right);
        }
    }

    public boolean search(T value) {
        return searchIteration(root, value);
    }

    private boolean searchIteration(Node<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (node.value.equals(value)) {
            return true;
        }
        if (value.compareTo(node.value) < 0) {
            return searchIteration(node.left, value);
        } else {
            return searchIteration(node.right, value);
        }
    }

    public T getRoot() {
        return root.value;
    }

    

    public void insert(T value) {
        root = insertIteration(root, value);
    }

    private Node<T> insertIteration(Node<T> node, T value) {
        if (node == null){
            return new Node<>(value, null, null);
        }
        if (node.value.equals(value)) {
            return node;
        }
        if (value.compareTo(node.value) < 0) {
            node.left = insertIteration(node.left, value);
        }else{
            node.right = insertIteration(node.right, value);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        
        int balance = getBalanceFactor(node);

        if (balance > 1 && value.compareTo(node.left.value) < 0)
            return rotateRight(node);
        if (balance < -1 && value.compareTo(node.right.value) > 0)
            return rotateLeft(node);
        if (balance > 1 && value.compareTo(node.left.value) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && value.compareTo(node.right.value) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public int treeHeight(){
        return getHeight(root);
    }

    private int getHeight(Node<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(Node<T> node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> R = node.right;
        Node<T> T2 = R.left;

        // 执行旋转
        R.left = node;
        node.right = T2;

        // 更新高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        R.height = 1 + Math.max(getHeight(R.left), getHeight(R.right));

        return R;
    }
    // private Node<T> rotateLeft(Node<T> node){
    //     Node<T> R = node.right;
    //     if (R.left != null) {
    //         Node<T> RL = R.left;
    //         R.left = node;
    //         node.right = RL;
    //         node.height = 1 + Math.max(node.left.height, node.right.height);
    //         R.height = 1 + Math.max(R.left.height, R.right.height);
    //         return R;
    //     }else{
    //         node.right = null;
    //         R.left = node;
    //         R.height = 1 + Math.max(R.left.height, R.right.height);
    //         node.height = 1 + node.left.height;
    //         return R;
    //     }
    // }

    // private Node<T> rotateRight(Node<T> node){
    //     Node<T> L = node.left;
    //     if (L.right != null) {
    //         Node<T> LR = L.right;
    //         L.right = node;
    //         node.left = LR;
    //         node.height = 1 + Math.max(node.left.height, node.right.height);
    //         L.height = 1 + Math.max(L.left.height, L.right.height);
    //         return L;
    //     }else{
    //         node.left = null;
    //         L.right = node;
    //         L.height = 1 + Math.max(L.left.height, L.right.height);
    //         node.height = 1 + node.right.height;
    //         return L;
    //     }
    // }
    private Node<T> rotateRight(Node<T> node) {
        Node<T> L = node.left;
        Node<T> T2 = L.right;

        // 执行旋转
        L.right = node;
        node.left = T2;

        // 更新高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        L.height = 1 + Math.max(getHeight(L.left), getHeight(L.right));

        return L;
    }


}
