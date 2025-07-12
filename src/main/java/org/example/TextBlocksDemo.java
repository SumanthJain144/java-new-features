package org.example;

public class TextBlocksDemo {

    public static void main(String[] args) {
        beforeScenario();

        afterScenario();
    }

    private static void beforeScenario() {
        String json = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": 30,\n" +
                "  \"city\": \"New York\"\n" +
                "}";

        System.out.println("JSON String formatted without text block literal: " + json);
    }

    private static void afterScenario() {

        String json = """
                {
                  "name": "John",
                  "age": 30,
                  "city": "New York"
                }
                """;


        System.out.println("JSON String formatted with text block literal: " + json);
    }
}
