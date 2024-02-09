package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] DP = new int[N];
        // N - 가장 긴 부분수열의 길이

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        DP[0] = 1;

        for (int i = 1; i < N; i++) {
            DP[i] = 1;

            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
        }

        int max = Arrays.stream(DP).max().getAsInt();
        System.out.println(N - max);

    }
}
