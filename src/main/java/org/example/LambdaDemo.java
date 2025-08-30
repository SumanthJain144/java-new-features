package org.example;

interface MessagePrinter {
    void printMessage(String message);
}

class UpperCasePrinter implements MessagePrinter {
    @Override
    public void printMessage(String message) {
        System.out.println(message.toUpperCase());
    }
}

class LowerCasePrinter implements MessagePrinter {
    @Override
    public void printMessage(String message) {
        System.out.println(message.toLowerCase());
    }
}

public class LambdaDemo {
    public static void main(String[] args) {
        MessagePrinter printer1 = new UpperCasePrinter();
        printer1.printMessage("Hello Java");

        MessagePrinter printer2 = new LowerCasePrinter();
        printer2.printMessage("Hello Java");
    }
}






