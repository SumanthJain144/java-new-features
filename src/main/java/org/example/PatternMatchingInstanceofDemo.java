package org.example;

public class PatternMatchingInstanceofDemo {

    public static void main(String[] args) {
        Object input = "Hello Pattern Matching";

        beforeScenario(input);
        afterScenario(input);
    }

    private static void beforeScenario(Object obj) {
        System.out.println("Before pattern matching for instanceof:");

        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Uppercase: " + str.toUpperCase());
        } else {
            System.out.println("Not a String");
        }
    }

    private static void afterScenario(Object obj) {
        System.out.println("\nAfter pattern matching for instanceof:");

        if (obj instanceof String str) {
            System.out.println("Uppercase: " + str.toUpperCase());
        } else {
            System.out.println("Not a String");
        }
    }
}
