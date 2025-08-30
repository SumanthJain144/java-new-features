package org.example;

import java.util.*;

/**
 *  Scenario
 *  ----------------------------------------
 * 	Start with a list of integers.
 * 	Multiply each by 3.
 * 	Filter only even numbers.
 * 	Sort them in descending order.
 * 	Print the first 3 numbers.
 */
public class StreamsDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 2, 8, 1, 5, 10, 12, 6);

        System.out.println("=== Before Scenario ===");
        beforeScenario(numbers);

        System.out.println("\n=== After Scenario ===");
        afterScenario(numbers);
    }

    // Before Streams (Imperative Style)
    static void beforeScenario(List<Integer> numbers) {
        List<Integer> multiplied = new ArrayList<>();
        for (Integer num : numbers) {
            multiplied.add(num * 3);
        }

        List<Integer> evens = new ArrayList<>();
        for (Integer num : multiplied) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }

        Collections.sort(evens, Collections.reverseOrder());

        int count = 0;
        for (Integer num : evens) {
            if (count < 3) {
                System.out.println(num);
                count++;
            } else {
                break;
            }
        }
    }

    // After Streams (Functional Style)
    static void afterScenario(List<Integer> numbers) {
        numbers.stream()
                .map(n -> n * 3)
                .filter(n -> n % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(n -> System.out.println(n));
    }
}
