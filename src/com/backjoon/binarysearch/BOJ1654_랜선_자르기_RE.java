package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1654_랜선_자르기_RE {

    static int K;
    static int N;
    static int[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lines = new int[K];

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        long answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        long lo = 1L;
        long hi = Integer.MAX_VALUE + 1L;

        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2L;

            if (check(mid)) hi = mid;
            else lo = mid;
        }

        return lo;
    }

    static boolean check(long mid) {
        long count = 0;

        for (int i = 0; i < K; i++) {
            count += (lines[i] / mid);
        }

        if (count < N) return true;
        else return false;
    }
}
