package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1654_랜선_자르기 {

    static int K;
    static int N;
    static long[] lines;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new long[K];

        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }

        long answer = solve();
        System.out.println(answer);
    }

    static long solve() {
        long start = 1;
        long end = Integer.MAX_VALUE;


        while (start < end) {
            long mid = (start + end + 1) / 2;
            int sum = 0;

            for (int i = 0; i < K; i++) {
                sum += lines[i] / mid;
            }

            if (sum >= N) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return start;

    }
}
