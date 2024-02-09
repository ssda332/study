package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ3151_합이_0 {

    static int N;
    static int[] A;
    static long count = 0L;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // O(N^2logN) = 400000000
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int target = A[i] + A[j];

                int num = upper_bound(j, target) - lower_bound(j, target);
                count += num;
            }
        }

        System.out.println(count);
    }

    static int lower_bound(int j, int target) {
        int lo = j;
        int hi = N;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (target + A[mid] >= 0) hi = mid;
            else lo = mid;

        }

        return hi;
    }

    static int upper_bound(int j, int target) {
        int lo = j;
        int hi = N;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (target + A[mid] > 0) hi = mid;
            else lo = mid;
        }

        return hi;
    }


}
