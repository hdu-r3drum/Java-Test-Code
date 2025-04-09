package com.dataStructure.Tests;
import com.dataStructure.Stack.*;

public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack<String> stack1 = new LinkedListStack<>();
        stack1.push("hello");
        stack1.push("Java");
        stack1.push("world");
        stack1.push("!");

        stack1.printStack();

        System.out.println(stack1.isEmpty());
        System.out.println(stack1.peek());
        System.out.println(stack1.pop());

        stack1.printStack();

        System.out.println("---------------------------------");

        ArrayListStack<String> stack2 = new ArrayListStack<>();
        stack2.push("hello");
        stack2.push("Java");
        stack2.push("world");
        stack2.push("!");

        stack2.printStack();

        System.out.println(stack2.isEmpty());
        System.out.println(stack2.peek());
        System.out.println(stack2.pop());

        stack2.printStack();

    }
}
