package edu.astanait;

import java.util.*;

public class BinarySearchTree<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    private class Node {
        private final K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        return x;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
            size--;
        }
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public int size() {
        return size;
    }

    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderTraversal(root, keys);
        return keys;
    }

    private void inOrderTraversal(Node x, List<K> keys) {
        if (x == null) return;
        inOrderTraversal(x.left, keys);
        keys.add(x.key);
        inOrderTraversal(x.right, keys);
    }

    public Iterable<Map.Entry<K, V>> entryIterator() {
        List<Map.Entry<K, V>> entries = new ArrayList<>();
        inOrderEntryTraversal(root, entries);
        return entries;
    }

    private void inOrderEntryTraversal(Node x, List<Map.Entry<K, V>> entries) {
        if (x == null) return;
        inOrderEntryTraversal(x.left, entries);
        entries.add(new AbstractMap.SimpleEntry<>(x.key, x.val));
        inOrderEntryTraversal(x.right, entries);
    }
}
