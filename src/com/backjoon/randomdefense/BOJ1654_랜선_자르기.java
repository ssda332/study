package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1654_랜선_자르기 {

    static int K;
    static int N;
    static int[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        max++;

        long result = upperBound(max);

        System.out.println(result - 1);
    }

    static long upperBound(long num) {
        long left = 0;
        long right = num;

        while (left < right) {
            long middle = left + (right - left) / 2;
            int count = 0;

            for (int i = 0; i < K; i++) {
                count += (lines[i] / middle);
            }

            if (count < N) {
                right = middle;
            } else {
                left = middle + 1;
            }

        }

        return left;
    }
}
