package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2473_세_용액 {

    static int N;
    static long[] A;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        int answer1 = 0;
        int answer2 = 1;
        int answer3 = 2;
        long sum = Math.abs(A[answer1] + A[answer2] + A[answer3]);

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                long target = A[i] + A[j];

                int k = binarySearch(j, target);
                if (Math.abs(A[i] + A[j] + A[k]) < sum) {
                    sum = Math.abs(A[i] + A[j] + A[k]);
                    answer1 = i;
                    answer2 = j;
                    answer3 = k;
                }
            }
        }

        System.out.println(A[answer1] + " " + A[answer2] + " " + A[answer3]);
    }

    static int binarySearch(int j, long target) {
        int lo = j + 1;
        int hi = N - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(target, mid)) {
                hi = mid;
            } else {
                lo = mid;
            }

        }

        if (Math.abs(target + A[lo]) < Math.abs(target + A[hi])) return lo;
        return hi;
    }

    static boolean check(long target, int idx) {
        long sum = target + A[idx];

        if (sum >= 0) return true;
        return false;
    }
}
