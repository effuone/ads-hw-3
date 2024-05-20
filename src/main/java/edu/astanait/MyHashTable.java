package edu.astanait;

public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private final K key;
        private final V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11; // default number of chains
    private int size;

    public MyHashTable() {
        // Constructor implementation
    }

    public MyHashTable(int M) {
        this.M = M;
        // Constructor implementation
    }

    private int hash(K key) {
        // Hash function implementation
        return 0; // placeholder
    }

    public void put(K key, V value) {
        // Put method implementation
    }

    public V get(K key) {
        // Get method implementation
        return null; // placeholder
    }

    public V remove(K key) {
        // Remove method implementation
        return null; // placeholder
    }

    public boolean contains(V value) {
        // Contains method implementation
        return false; // placeholder
    }

    public K getKey(V value) {
        // GetKey method implementation
        return null; // placeholder
    }
}

