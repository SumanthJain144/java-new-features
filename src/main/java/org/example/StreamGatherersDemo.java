package org.example;

import java.util.List;
import java.util.stream.Gatherers;
import java.util.stream.IntStream;


public class StreamGatherersDemo {

    public static void main(String[] args) {
        List<String> input = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

        System.out.println("Before Stream Gatherers:");
        beforeScenario(input);

        System.out.println("\n After Stream Gatherers:");
        afterScenario(input);
    }

    private static void beforeScenario(List<String> input) {

        System.out.println("Group into fixed-size windows (pairs):");
        IntStream.range(0, input.size() / 2)
                .mapToObj(i -> List.of(input.get(i * 2), input.get(i * 2 + 1)))
                .forEach(System.out::println);


        System.out.println("\nSliding window (size 3):");
        IntStream.range(0, input.size() - 2)
                .mapToObj(i -> List.of(input.get(i), input.get(i + 1), input.get(i + 2)))
                .forEach(System.out::println);
    }

    private static void afterScenario(List<String> input) {

        System.out.println("windowFixed(2):");
        input.stream()
                .gather(Gatherers.windowFixed(2))
                .forEach(System.out::println);

        System.out.println("\nwindowSliding(3):");
        input.stream()
                .gather(Gatherers.windowSliding(3))
                .forEach(System.out::println);
    }
}
