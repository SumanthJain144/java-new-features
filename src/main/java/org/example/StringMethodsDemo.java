package org.example;


public class StringMethodsDemo {

    public static void main(String[] args) {
        isBlankDemo();
        linesDemo();
        stripDemo();
        repeatDemo();
    }

    private static void isBlankDemo() {
        System.out.println("---- isBlank() Demo ----");
        beforeIsBlank();
        afterIsBlank();
    }

    private static void beforeIsBlank() {
        String input = "   ";
        boolean isBlank = input.isEmpty();
        System.out.println("Before isBlank(): " + isBlank);
    }

    private static void afterIsBlank() {
        String input = "   ";
        boolean isBlank = input.isBlank();
        System.out.println("After isBlank(): " + isBlank);
    }

    private static void linesDemo() {
        System.out.println("\n---- lines() Demo ----");
        beforeLines();
        afterLines();
    }

    private static void beforeLines() {
        String text = "Java\nPython\r\nGo\rRust";
        String[] lines = text.split("\n"); // only splits on \n

        System.out.println("Using split(\"\\n\"):");
        for (String line : lines) {
            System.out.println("[" + line + "]");
        }
    }

    private static void afterLines() {
        String text = "Java\nPython\r\nGo\rRust";

        System.out.println("\nUsing lines():");
        text.lines().forEach(line -> System.out.println("[" + line + "]"));
    }

    private static void stripDemo() {
        System.out.println("\n---- strip(), stripLeading(), stripTrailing() Demo ----");
        beforeStrip();
        afterStrip();
    }

    private static void beforeStrip() {
        String value = "\u2003\u2003 Hello World \u2003"; // includes unicode whitespace
        System.out.println("Before strip(): '" + value.trim() + "'");
    }

    private static void afterStrip() {
        String value = "\u2003\u2003 Hello World \u2003";
        System.out.println("After strip(): '" + value.strip() + "'");
        System.out.println("After stripLeading(): '" + value.stripLeading() + "'");
        System.out.println("After stripTrailing(): '" + value.stripTrailing() + "'");
    }

    private static void repeatDemo() {
        System.out.println("\n---- repeat() Demo ----");
        beforeRepeat();
        afterRepeat();
    }

    private static void beforeRepeat() {
        String str = "Hi ";
        String result = "";
        for (int i = 0; i < 3; i++) {
            result += str;
        }
        System.out.println("Before repeat(): " + result);
    }

    private static void afterRepeat() {
        String str = "Hi ";
        String result = str.repeat(3);
        System.out.println("After repeat(): " + result);
    }
}
