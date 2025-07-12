package org.example;

public class SealedTypesComparisonDemo {

    public static void main(String[] args) {
        beforeScenario();
        afterScenario();
    }

    private static void beforeScenario() {
        System.out.println("Before sealed types:");

        ShapeBefore shape1 = new CircleBefore(5.0);
        ShapeBefore shape2 = new UnknownShapeBefore();

        printShape(shape1);
        printShape(shape2);
    }

    private static void afterScenario() {
        System.out.println("\nAfter sealed types:");

        Shape shape1 = new Circle(5.0);
        // Shape shape2 = new UnknownShape();

        printShape(shape1);
    }

    private static void printShape(Object shape) {
        if (shape instanceof CircleBefore c) {
            System.out.println("CircleBefore with radius: " + c.radius());
        } else if (shape instanceof UnknownShapeBefore) {
            System.out.println("Unknown shape detected!");
        } else if (shape instanceof Circle c) {
            System.out.println("Circle (sealed) with radius: " + c.radius());
        }
    }

    interface ShapeBefore { }

    static class CircleBefore implements ShapeBefore {
        private final double radius;
        public CircleBefore(double radius) { this.radius = radius; }
        public double radius() { return radius; }
    }

    static class UnknownShapeBefore implements ShapeBefore { }


    sealed interface Shape permits Circle, Rectangle, Square { }

    record Circle(double radius) implements Shape { }
    record Rectangle(double width, double height) implements Shape { }
    record Square(double side) implements Shape { }
}
