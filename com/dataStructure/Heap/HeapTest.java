package com.dataStructure.Heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap(6);
        heap.push(4);
        heap.push(3);
        heap.push(2);
        heap.push(1);
        heap.push(5);
        heap.push(6);
        heap.push(7); // out of capacity
        heap.getHeap();
        System.out.println(heap.pop());
        heap.getHeap();
        System.out.println(heap.pop());
        heap.getHeap();
        System.out.println(heap.pop());
        heap.getHeap();
        System.out.println(heap.pop());
        heap.getHeap();
        System.out.println(heap.pop());
        heap.getHeap();
        System.out.println(heap.pop());
        heap.getHeap();
        System.out.println(heap.pop()); // run out of
    }
}
