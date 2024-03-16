package com.backjoon.string;

import java.util.*;
import java.io.*;

public class BOJ11656_접미사_배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            String substring = S.substring(i, S.length());
            set.add(substring);
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        list.stream().forEach(s -> {
            sb.append(s).append("\n");
        });

        System.out.println(sb);


    }
}
