package com.dataStructure.Stack;

// import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListStack<T>{
    private int top;
    // private int stackSize;
    private ArrayList<Node> arrayStack;

    private class Node<T>{
        private T data;
        Node(T data){
            this.data = data;
        }
    }

    public ArrayListStack(){
        top = -1;
        // stackSize = 0;
        arrayStack = new ArrayList<>();
    }

    public boolean isEmpty(){
        // return (stackSize == 0)? true : false;
        return (top == -1)? true : false;
    }

    public void push(T data){
        Node<T> node = new Node<>(data);
        if(arrayStack.add(node)){
            top++;
            // stackSize++;
        }
    }

    public T peek(){
        if(isEmpty()){
            return (T)null;
        }
        return (T) arrayStack.get(top).data;
    }

    public T pop(){
        if(isEmpty()){
            return (T)null;
        }
        T data = peek();
        top--;
        return data;
    }

    public void printStack(){
        if(isEmpty()){
            return;
        }
        int i = top;
        for (; i > 0; i--) {
            System.out.print((T) arrayStack.get(i).data + " ");
        }
        System.out.println((T) arrayStack.get(i).data);
    }
}
