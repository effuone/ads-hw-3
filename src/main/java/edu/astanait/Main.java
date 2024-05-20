package edu.astanait;
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
    }
}