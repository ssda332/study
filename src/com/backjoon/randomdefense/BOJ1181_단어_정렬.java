package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1181_단어_정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.stream(words).distinct()
                        .sorted(new Comparator<String>() {
                           @Override
                           public int compare(String o1, String o2) {
                               if (o1.length() == o2.length()) {
                                   return o1.compareTo(o2);
                               }
                               return o1.length() - o2.length();
                           }
                        })
                .forEach(System.out::println);
    }
}

