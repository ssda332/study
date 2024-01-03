package com.backjoon.string;

import java.util.*;
import java.io.*;

public class BOJ4358_생태학 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        int count = 0;
        String s;

        while ((s = br.readLine()) != null) {
            if (s.equals("")) break;

            count++;
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + String.format("%.4f", (double)(entry.getValue() * 100) / (double)count));
        }

    }
}
