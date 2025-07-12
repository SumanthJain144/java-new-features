package org.example;

public class SwitchExpressionDemo {

    public static void main(String[] args) {
        Month month = Month.FEBRUARY;

        beforeScenario(month);
        afterScenario(month);
    }

    private static void beforeScenario(Month month) {
        int days;
        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                days = 31;
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                days = 30;
                break;
            case FEBRUARY:
                boolean isLeapYear = false;
                if (isLeapYear) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown month: " + month);
        }

        System.out.println("Before switch expression: " + month + " has " + days + " days.");
    }

    private static void afterScenario(Month month) {
        int days = switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            case FEBRUARY -> {
                boolean isLeapYear = false;
                yield isLeapYear ? 29 : 28;
            }
        };

        System.out.println("After switch expression: " + month + " has " + days + " days.");
    }

    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
        JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }
}
