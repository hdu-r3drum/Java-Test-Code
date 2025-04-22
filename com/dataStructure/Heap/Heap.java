package com.dataStructure.Heap;

public class Heap {
    private int[] heap;
    private int size;
    private int capacity;

    public Heap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int[] getChildrensIndex(int index){
        int[] res = new int[2];
        res[0] = (index + 1) * 2 - 1;
        res[1] = (index + 1) * 2 ;
        return res;
    }

    private int getParentIndex(int index){
        if (index % 2 == 0){
            return (index / 2) - 1;
        }else{
            return index / 2;
        }
    }

    public void push(int val){
        if(size == capacity){
            return;
        }
        heap[size] = val;
        size++;
        adjustUp(size - 1);
    }

    private void adjustUp(int index){
        adjustUpIteration(index);
    }

    private void adjustUpIteration(int index){
        if (index == 0){
            return;
        }
        int parent = getParentIndex(index);
        if (heap[index] < heap[getParentIndex(index)]){
            int temp = heap[index];
            heap[index] = heap[getParentIndex(index)];
            heap[getParentIndex(index)] = temp;
            adjustUpIteration(parent);
        }
    }

    public int pop(){
        if (size == 0){
            return -1;
        }
        int top = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = 0;
        size--;
        adjustDown(0);
        return top;
    }

    private void adjustDown(int index){
        adjustDownIteration(index);
    }

    private void adjustDownIteration(int index){
        if (index >= size){
            return;
        }
        int left = (index + 1) * 2 - 1;
        int right = (index + 1) * 2;
        int min = right;
        if (left >= size){
            return;
        }
        if (right >= size){
            if (heap[left] >= heap[index]) return;
            min = left;
        }
        if (right < size) {
            if (heap[left] >= heap[index] && heap[right] >= heap[index]) return;
            min = heap[left] < heap[right] ? left : right;
        }
        int temp = heap[min];
        heap[min] = heap[index];
        heap[index] = temp;
        adjustDownIteration(min);
    }

    public int peek(){
        if (size == 0){
            return -1;
        }
        return heap[0];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void getHeap(){
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println("");
    }
}
