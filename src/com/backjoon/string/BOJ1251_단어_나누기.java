package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ1251_단어_나누기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int N = s.length();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                StringBuilder sb = new StringBuilder();

                StringBuilder sb1 = new StringBuilder(s.substring(0, i));
                StringBuilder sb2 = new StringBuilder(s.substring(i, j));
                StringBuilder sb3 = new StringBuilder(s.substring(j));

                sb.append(sb1.reverse()).append(sb2.reverse()).append(sb3.reverse());
                list.add(sb.toString());
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
