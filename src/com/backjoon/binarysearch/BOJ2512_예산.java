package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2512_예산 {

    static int N;
    static int[] A;
    static int budget;
    static boolean flag = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        budget = Integer.parseInt(br.readLine());
        Arrays.sort(A);
        int sum = Arrays.stream(A).sum();
        if (sum <= budget) {
            System.out.println(Arrays.stream(A).max().getAsInt());
        } else {
            int max = binarySearch();
            System.out.println(max);
        }

    }

    static int binarySearch() {
        int lo = 0;
        int hi = Arrays.stream(A).max().getAsInt();
        // 상한액 target

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }

        }
        if (flag) return hi;
        return lo;
    }

    static boolean check(int mid) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > mid) {
                sum += mid;
            } else {
                sum += A[i];
            }
        }

        if (sum > budget) {
            return true;
        } else if (sum == budget) {
            flag = true;
            return true;
        } else {
            return false;
        }
    }
}
