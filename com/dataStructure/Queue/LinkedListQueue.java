package com.dataStructure.Queue;

// import java.lang.classfile.components.ClassPrinter;

public class LinkedListQueue<T>{
    private LinkedList<T> queue;
    private int queueSize = 0;
    
    private class LinkedList<T>{
        private Node<T> frontNode;
        private Node<T> rearNode;
        
        LinkedList() {
            Node<T> node = new Node<>(null, null, null);
            frontNode = node;
            rearNode = node;
        }
        
    }

    private class Node<T>{
        private T data;
        private Node<T> next;
        private Node<T> pre;

        Node(T data,Node<T> pre, Node<T> next){
            this.data = data;
            this.next = next;
            this.pre = pre;
        }
    }
    
    public LinkedListQueue(){
        this.queue = new LinkedList<>();
    }

    public boolean isEmpty(){
        return (queue.frontNode == queue.rearNode)? true : false;
    }

    public void push(T data){
        Node<T> node = new Node<>(data, null, queue.rearNode);
        queue.rearNode = node;
        queueSize++;
    }

    public T pop(){
        if(isEmpty()){
            return (T)null;
        }
        T data = queue.frontNode.data;
        Node<T> tempNode = queue.frontNode.pre;
        queue.frontNode = null;
        queue.frontNode = tempNode;
        queueSize--;
        return data;
    }

    public void printQueue(){
        if(isEmpty()){
            return;
        }
        Node<T> node = queue.rearNode;
        while(node.next.next != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println(node.data);
    }
}