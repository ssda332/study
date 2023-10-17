package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2295_세_수의_합 {

    static int N;
    static int[] A;
    static int[] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            A[i] = num;
        }

        int maxSize = N * (N + 1) / 2;
        sums = new int[maxSize];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[idx] = A[i] + A[j];
                idx++;
            }
        }

        Arrays.sort(sums);

        int result = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = A[i] - A[j];

                if (binarySearch(target)) {
                    result = Math.max(result, A[i]);
                }
            }
        }

        System.out.println(result);

    }

    static boolean binarySearch(int num) {
        int left = 0;
        int right = sums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (sums[middle] > num) {
                right = middle - 1;
            } else if (sums[middle] < num) {
                left = middle + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
