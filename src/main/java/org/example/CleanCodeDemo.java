package org.example;

import java.util.List;

public class CleanCodeDemo {
    record Student(String name, int marks) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", 85),
                new Student("Bob", 35),
                new Student("Charlie", 65)
        );

        double average = calculateAverage(students);
        System.out.println("""
                ------------------------
                Average Marks: %.2f
                ------------------------
                """.formatted(average));

        printPassedStudents(students);
    }

    private static double calculateAverage(List<Student> students) {
        return students.stream()
                .mapToInt(Student::marks)
                .average()
                .orElse(0.0);
    }

    private static void printPassedStudents(List<Student> students) {
        System.out.println("Students who passed:");
        students.stream()
                .filter(s -> s.marks() >= 40)
                .map(Student::name)
                .forEach(System.out::println);
    }
}
