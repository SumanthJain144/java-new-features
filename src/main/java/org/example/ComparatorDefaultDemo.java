package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDefaultDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 5, 3);

        // Before Java 8: Anonymous inner class for reverse order
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a); // Reverse order
            }
        });
        System.out.println("Before Java 8 (Reverse): " + numbers);

        // Java 8: Using Lambda for reverse order
        numbers = Arrays.asList(1, 4, 2, 5, 3);
        Collections.sort(numbers, (a, b) -> b.compareTo(a));
        System.out.println("Java 8 with Lambda (Reverse): " + numbers);

        // Java 8: Using default method reversed()
        numbers = Arrays.asList(1, 4, 2, 5, 3);
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println("Java 8 with default method (Reverse): " + numbers);
    }
}
