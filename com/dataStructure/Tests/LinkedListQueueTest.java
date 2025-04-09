package com.dataStructure.Tests;
import com.dataStructure.Queue.ArrayListQueue;
import com.dataStructure.Queue.LinkedListQueue;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        System.out.println("LinkedListQueue Test");
        LinkedListQueue<String> queue1 = new LinkedListQueue<>();
        queue1.push("hello");
        queue1.push("Java");
        queue1.push("world");
        queue1.push("!");

        queue1.printQueue();

        System.out.println(queue1.isEmpty());
        System.out.println(queue1.pop());

        queue1.printQueue();

        System.out.println("-----------------------");
        System.out.println("ArrayListQueue Test");

        ArrayListQueue<String> queue2 = new ArrayListQueue<>();
        queue2.push("hello");
        queue2.push("Java");
        queue2.push("world");
        queue2.push("!");

        queue2.printQueue();

        System.out.println(queue2.isEmpty());
        System.out.println(queue2.pop());

        queue2.printQueue();
        
    }
}
