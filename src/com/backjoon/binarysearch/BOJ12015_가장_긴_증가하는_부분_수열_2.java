package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ12015_가장_긴_증가하는_부분_수열_2 {

    static int N;
    static int[] A;
    static int[] LIS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        LIS = new int[1000000];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = A[0];

        int lisIdx = 1;

        for (int i = 1; i < N; i++) {
            if (A[i] > LIS[lisIdx - 1]) {
                LIS[lisIdx] = A[i];
                lisIdx++;
            } else if (A[i] < LIS[lisIdx - 1]) {
                int idx = binarySearch(lisIdx, i);
                LIS[idx] = A[i];
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (LIS[i] != 0) answer++;
            else break;
        }

        System.out.println(answer);
    }

    static int binarySearch(int idx, int i) {
        int lo = -1;
        int hi = idx - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(mid, i)) hi = mid;
            else lo = mid;

        }

        return hi;
    }

    static boolean check(int target, int i) {
        if (LIS[target] >= A[i]) return true;
        return false;
    }
}
