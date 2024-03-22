package com.backjoon.queue;

import java.io.*;
import java.util.*;

public class BOJ11286_절댓값_힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int o1Abs = Math.abs(o1);
            int o2Abs = Math.abs(o2);
            if (o1Abs == o2Abs) return Integer.compare(o1, o2);
            return Integer.compare(o1Abs, o2Abs);
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                pq.add(n);
            } else {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
