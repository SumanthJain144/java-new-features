package org.example;

import java.util.*;

public class DirtyCodeDemo {
    public static void main(String[] args) {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> s1 = new HashMap<>();
        s1.put("n", "Alice");
        s1.put("m", 85);
        data.add(s1);
        Map<String, Object> s2 = new HashMap<>();
        s2.put("n", "Bob");
        s2.put("m", 35);
        data.add(s2);
        Map<String, Object> s3 = new HashMap<>();
        s3.put("n", "Charlie");
        s3.put("m", 65);
        data.add(s3);

        int total = 0;
        for (int i = 0; i < data.size(); i++) {
            total += (Integer) data.get(i).get("m");
        }
        double avg = total / data.size();
        System.out.println("avg:" + avg);

        for (int i = 0; i < data.size(); i++) {
            if ((Integer) data.get(i).get("m") >= 40) {
                System.out.println("passed:" + data.get(i).get("n"));
            }
        }
    }
}
