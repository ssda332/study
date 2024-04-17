package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2512_예산_RE {

    static int N;
    static int[] B;
    static int budget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        budget = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        if (Arrays.stream(B).sum() <= budget) {
            answer = Arrays.stream(B).max().getAsInt();
        } else {
            answer = binarySearch();
        }

        System.out.println(answer);
    }

    static int binarySearch() {
        int lo = -1;
        int hi = budget;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(mid)) hi = mid;
            else lo = mid;
        }

        return lo;
    }

    static boolean check(int mid) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (B[i] > mid) {
                sum += mid;
            } else {
                sum += B[i];
            }
        }

        if (sum > budget) return true;
        else return false;
    }
}
