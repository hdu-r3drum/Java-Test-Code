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
        return (queueSize == 0)? true : false;
    }

    public void push(T data){
        Node<T> node = new Node<>(data, queue.rearNode, null);
        queue.rearNode.next = node;
        queue.rearNode = node;
        queueSize++;
    }

    public T pop(){
        if(isEmpty()){
            return (T)null;
        }
        Node<T> node = queue.frontNode.next;
        T data = node.data;
        queue.frontNode.next = node.next;
        if(node.next != null){
            node.next.pre = queue.frontNode;
        }else{
            queue.rearNode = queue.frontNode;
        }
        queueSize--;
        return data;
    }

    public void printQueue(){
        if(isEmpty()){
            return;
        }
        Node<T> node = queue.frontNode.next;
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}