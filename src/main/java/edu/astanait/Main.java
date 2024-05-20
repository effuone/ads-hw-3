package edu.astanait;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(11);

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000);
            MyTestingClass key = new MyTestingClass(id);
            Student value = new Student("Student" + id, random.nextInt(100));
            table.put(key, value);
        }

        int[] bucketSizes = table.getBucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }

        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        // Adding elements
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(2, "Two");
        bst.put(4, "Four");
        bst.put(6, "Six");
        bst.put(8, "Eight");

        // Getting elements
        System.out.println("Value for key 4: " + bst.get(4));

        // Deleting elements
        bst.delete(4);
        System.out.println("Value for key 4 after deletion: " + bst.get(4));

        // Size
        System.out.println("Size of BST: " + bst.size());

        // In-order traversal for keys
        System.out.println("In-order traversal of keys:");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }

        // In-order traversal for entries
        System.out.println("In-order traversal of entries:");
        for (Map.Entry<Integer, String> entry : bst.entryIterator()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}