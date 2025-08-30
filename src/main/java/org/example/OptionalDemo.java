package org.example;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        beforeOptional();
        afterOptional();
    }

    // Before Java 8: Null checks
    static void beforeOptional() {
        System.out.println("=== Before Java 8 ===");
        String name = getUserNameOld();

        if (name != null) {
            System.out.println("Name length: " + name.length());
        } else {
            System.out.println("Name not available");
        }
    }

    // After Java 8: Using Optional
    static void afterOptional() {
        System.out.println("=== After Java 8 (Optional) ===");
        Optional<String> nameOpt = getUserName();

        // ifPresentOrElse (functional style)
        nameOpt.ifPresentOrElse(
                name -> System.out.println("Name length: " + name.length()),
                () -> System.out.println("Name not available")
        );

        // Show chaining with map() and orElse()
        String upperName = nameOpt.map(String::toUpperCase)
                .orElse("DEFAULT NAME");
        System.out.println("Processed name: " + upperName);
    }

    static String getUserNameOld() {
        return Math.random() > 0.5 ? "Alice" : null;
    }

    static Optional<String> getUserName() {
        return Math.random() > 0.5 ? Optional.of("Alice") : Optional.empty();
    }
}
