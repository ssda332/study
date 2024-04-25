package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2805_나무_자르기 {

    static int N;
    static int M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trees = new int[N];

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int lo = 0;
        int hi = 1000000001;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(mid)) hi = mid;
            else lo = mid;
        }

        return lo;
    }

    static boolean check(int mid) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (trees[i] > mid) sum += (trees[i] - mid);
        }

        // m보다 작으면 높이 내려야함
        if (M > sum) {
            return true;
        } else {
            return false;
        }
    }
}
