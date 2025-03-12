package com.dataStructure.Queue;

public class ArrayListQueue <T>{
    private ArrayList<T> queue;
    private int queueSize = 0;

    private class ArrayList<T>{
        private T[] data;
        private int front;
        private int rear;

        ArrayList(){
            data = (T[])new Object[10]; //转换成泛型数组
            front = 0;
            rear = 0;
        }
    }

    public ArrayListQueue(){
        this.queue = new ArrayList<>();
    }

    public boolean isEmpty(){
        return (queueSize == 0)? true : false;
    }

    public void push(T data){
        if(queue.rear == queue.data.length){
            T[] newData = (T[])new Object[queue.data.length * 2];
            for(int i = 0; i < queue.data.length; i++){
                newData[i] = queue.data[i];
            }
            queue.data = null;
            queue.data = newData;
        }
        queue.data[queue.rear] = data;
        queue.rear++;
        queueSize++;
    }

    public T pop(){
        if(isEmpty()){
            return (T)null;
        }
        T data = queue.data[queue.front];
        for(int i = 0; i < queue.rear - 1; i++){
            queue.data[i] = queue.data[i + 1];
        }
        queue.rear--;
        queueSize--;
        return data;
    }

    public void printQueue(){
        for(int i = 0; i < queue.rear - 1; i++){
            System.out.print(queue.data[i] + " ");
        }
        System.out.println(queue.data[queue.rear - 1]);
    }
}
