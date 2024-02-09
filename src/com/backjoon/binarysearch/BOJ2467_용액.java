package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2467_용액 {

    static int N;
    static int[] A;
    static int answerA = 0;
    static int answerB = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            int result = binarySearch(i);
            int sum = A[i] + A[result];
            if (Math.abs(sum) < Math.abs(A[answerA] + A[answerB])) {
                answerA = i;
                answerB = result;
            }

        }

        System.out.println(A[answerA] + " " + A[answerB]);

    }

    static int binarySearch(int cur) {
        int lo = cur + 1;
        int hi = N - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(cur, mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

//        if (check(cur, lo) && check(cur, hi)) return lo;
        if (Math.abs(A[cur] + A[lo]) < Math.abs(A[cur] + A[hi])) return lo;
        return hi;
    }

    static boolean check(int cur, int mid) {
        int sum = A[cur] + A[mid];

        if (sum >= 0) return true;
        return false;
    }
}
