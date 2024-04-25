package com.algorithm.baaarkingdog.chapter1;

import java.util.*;

public class BOJ1076_저항 {

    public static void main(String[] args) {
        HashMap<String, Long[]> map = new HashMap<>();
        map.put("black", new Long[] {0L, 1L});
        map.put("brown", new Long[] {1L, 10L});
        map.put("red", new Long[] {2L, 100L});
        map.put("orange", new Long[] {3L, 1000L});
        map.put("yellow", new Long[] {4L, 10000L});
        map.put("green", new Long[] {5L, 100000L});
        map.put("blue", new Long[] {6L, 1000000L});
        map.put("violet", new Long[] {7L, 10000000L});
        map.put("grey", new Long[] {8L, 100000000L});
        map.put("white", new Long[] {9L, 1000000000L});

        Scanner sc = new Scanner(System.in);

        String r1 = sc.nextLine();
        String r2 = sc.nextLine();
        String r3 = sc.nextLine();

        long answer = (map.get(r2)[0] + (10L * map.get(r1)[0])) * map.get(r3)[1];

        System.out.println(answer);
    }
}
