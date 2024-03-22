package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ1302_베스트셀러 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        String name = "";

        for (int i = 0; i < N; i++) {
            String book = br.readLine();

            if (map.containsKey(book)) {
                int cnt = map.get(book);
                map.put(book, cnt + 1);
            } else {
                map.put(book, 1);
            }

            int cnt = map.get(book);
            if (cnt > max) {
                max = cnt;
                name = book;
            } else if (cnt == max) {
                int n = name.compareTo(book);
                if (n > 0) {
                    name = book;
                }
            }
        }

        System.out.println(name);


    }
}
