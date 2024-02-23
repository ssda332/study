package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ14921_용액_합성하기 {

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(A);
        if (N == 2) {
            System.out.println(A[0] + A[1]);
            return;
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            int idx = binarySearch(i);

            int sum = A[idx] + A[i];

            if (Math.abs(sum) < Math.abs(answer)) answer = sum;
        }

        System.out.println(answer);

    }

    static int binarySearch(int cur) {
        int lo = cur + 1;
        int hi = N - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            int sum = A[mid] + A[cur];

            if (check(sum)) {
                hi = mid;
            } else {
                lo = mid;
            }

        }

        if (Math.abs(A[cur] + A[lo]) < Math.abs(A[cur] + A[hi])) return lo;
        return hi;
    }

    static boolean check(int sum) {
        if (sum >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
