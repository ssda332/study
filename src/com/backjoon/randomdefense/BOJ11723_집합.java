package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int N = 0;
            if (input.length > 1) N = Integer.parseInt(input[1]);


            if (command.equals("add")) {
                set.add(N);
            } else if (command.equals("remove")) {
                set.remove(N);
            } else if (command.equals("check")) {
                if (set.contains(N)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("toggle")) {
                if (set.contains(N)) {
                    set.remove(N);
                } else {
                    set.add(N);
                }
            } else if (command.equals("all")) {
                set = new HashSet<>();

                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (command.equals("empty")) {
                set = new HashSet<>();
            }
        }

        System.out.println(sb);
    }
}
