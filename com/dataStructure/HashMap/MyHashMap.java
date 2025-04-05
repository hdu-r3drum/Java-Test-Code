package com.dataStructure.HashMap;

public class MyHashMap<K ,V>{

    private Node<K, V>[] table = new Node[16];

    private int size = 0;

    private final float loadFactor = 0.75f;
    
    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node<K, V> node = (Node<K, V>) obj;
            return key.equals(node.key) && value.equals(node.value);
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
    }

    public V put(K key, V value) {
        if (key == null) {
            return null;
        }
        if (size >= table.length * loadFactor) {
            resize();
        }
        int index = indexOf(key);
        Node<K, V> node = table[index];
        if (node == null) {
            table[index] = new Node<K, V>(key, value, null);
            size++;
            return null;
        }
        while (node != null) {
            if (node.key.equals(key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            if (node.next == null) {
                node.next = new Node<K, V>(key, value, null);
                size++;
                return null;
            }
            node = node.next;
        }
        return null;
    }
    public V get(K key) {
        int index = indexOf(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key) {
        int index = indexOf(key);
        Node<K, V> node = table[index];
        if(node == null){
            return null;
        }
        Node<K, V> prev = null;
        if(node.key.equals(key)){
            Node<K, V> oldNode = node;
            node = node.next;
            size--;
            return oldNode.value;
        }else{
            prev = node;
            node = node.next;
        }
        while(node != null){
            if(node.key.equals(key)){
                Node<K, V> oldNode = node;
                prev.next = node.next;
                node = null;
                size--;
                return oldNode.value;
            }
        }
        return null;
    }
    public boolean containsKey(K key) {
        int index = indexOf(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
    public int size() {
        return this.size;
    }
    private void resize() {
        Node<K, V>[] newTable = new Node[table.length * 2];
        for (Node<K, V> node : table) {
            if (node != null) {
                int index = node.key.hashCode() % newTable.length;
                if (newTable[index] == null) {
                    newTable[index] = node;
                } else {
                    Node<K, V> temp = newTable[index];
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = node;
                }
            }
        }
        table = newTable;
        System.out.println("Resized to: " + table.length);
    }
    public boolean isEmpty() {
        return (size == 0)? true : false;
    }
    private int indexOf(Object key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() % table.length;
    }
    
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<K, V> node : table) {
            if (node != null) {
                sb.append(node.toString()).append("\n");
            }
        }
        return sb.toString();
    }

}