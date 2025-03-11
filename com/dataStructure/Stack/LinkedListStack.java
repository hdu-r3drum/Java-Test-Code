package com.dataStructure.Stack;

public class LinkedListStack<T>{
    private Node<T> top;
    private int stackSize = 0;

    private static class Node<T>{
        T data;
        Node<T> next;
        Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }

    public LinkedListStack(){
        top = null;
        stackSize = 0;
    }

    public boolean isEmpty(){
        return (stackSize == 0)? true : false;
    }

    public T peek(){
        return top.data;
    }

    public void push(T data){
        Node<T> node = new Node<>(data, top);
        top = node;
        stackSize++;
    }

    public T pop(){
        T data = peek();
        top = top.next;
        stackSize--;
        return data;
    }

    public void printStack(){
        if(isEmpty()){
            return;
        }
        Node<T> node = top;
        // while(node.next != null){
        //     System.out.print(node.data + " ");
        //     node = node.next;
        // }
        for(int i = 0; i < stackSize - 1; i++){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println(node.data);
    }
}