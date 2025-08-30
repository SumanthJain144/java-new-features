package org.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuncInterfacesDemo {
    public static void main(String[] args) {
        Consumer<String> printer = msg -> System.out.println(msg);
        printer.accept("Hello Consumer");

        Predicate<String> checkLength = str -> str.length() > 5;
        System.out.println(checkLength.test("Lambda")); // true

        Function<String, Integer> lengthFunc = str -> str.length();
        System.out.println(lengthFunc.apply("Hello")); // 5
    }
}
