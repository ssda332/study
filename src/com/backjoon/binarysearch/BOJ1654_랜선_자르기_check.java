package com.backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654_랜선_자르기_check {

    static int K;
    static Long N;
    static long[] lines;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Long.parseLong(st.nextToken());
        lines = new long[K];

        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }

        long answer = solve();
        System.out.println(answer);
    }

    static long solve() {
        long start = 1;
        long end = Integer.MAX_VALUE + 1L;

        while (start + 1 < end) {
            long mid = (start + end) / 2;

            if (check(mid)) start = mid;
            else end = mid;
        }

        System.out.println("start : " + start);
        System.out.println("end : " + end);

        return start;

    }

    static boolean check(long mid) {
        long sum = 0;

        for (int i = 0; i < K; i++) {
            sum += lines[i] / mid;
        }
        return sum >= N;
    }
}
