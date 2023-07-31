package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1715_카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }
        while (queue.size() != 1) {
            int c1 = queue.poll();
            int c2 = queue.poll();
            sum += c1 + c2;
            queue.add(c1 + c2);
        }
        System.out.println(sum);

    }
}
