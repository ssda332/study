package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1927_최소_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    int poll = queue.poll();
                    sb.append(poll).append("\n");
                }
            } else {
                queue.add(input);
            }
        }

        System.out.println(sb);

    }
}
