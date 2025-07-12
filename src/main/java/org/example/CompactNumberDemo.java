package org.example;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberDemo {

    public static void main(String[] args) {
        beforeScenario();
        afterScenario();
    }

    private static void beforeScenario() {
        long followers = 1200;
        long views = 1500000;
        long likes = 980;

        System.out.println("Before Compact Formatting (manual logic):");
        System.out.println("Followers: " + formatManually(followers));
        System.out.println("Views: " + formatManually(views));
        System.out.println("Likes: " + formatManually(likes));
    }

    private static void afterScenario() {
        long followers = 1234;
        long views = 1500000;
        long likes = 980;

        Long a= Long.valueOf(1000L);

        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        formatter.setMaximumFractionDigits(1);

        System.out.println("\nAfter Compact Formatting (Java 12+):");
        System.out.println("Followers: " + formatter.format(followers));  //Followers: 1.2K
        System.out.println("Views: " + formatter.format(views)); //Views: 1.5M
        System.out.println("Likes: " + formatter.format(likes)); //Likes: 980

        System.out.println("double: " + formatter.format(a));
    }

    private static String formatManually(long number) {
        if (number >= 1_000_000_000) {
            return String.format("%.1fB", number / 1_000_000_000.0);
        } else if (number >= 1_000_000) {
            return String.format("%.1fM", number / 1_000_000.0);
        } else if (number >= 1_000) {
            return String.format("%.1fK", number / 1_000.0);
        } else {
            return String.valueOf(number);
        }
    }
}
