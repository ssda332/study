package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579_계단_오르기_RE_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] DP = new int[N][2];
        int[] A = new int[N + 2];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }



        DP[0][0] = A[0]; DP[0][1] = A[0];
        DP[1][0] = A[1]; DP[1][1] = A[0] + A[1];

        // 0 전 계단을 밟지않은 경우 1 전 계단을 밟은경우
        // DP[i][0] : Math.max(DP[i - 2][0], DP[i - 2][1]) + A[i];
        // DP[i][1] : Math.max(DP[i - 1][0], DP[i - 1][1]) + A[i];
        for (int i = 2; i < N; i++) {
            DP[i][0] = Math.max(DP[i - 2][0], DP[i - 2][1]) + A[i];
            DP[i][1] = DP[i - 1][0] + A[i];
        }

        System.out.println(Math.max(DP[N - 1][0], DP[N - 1][1]));
    }
}
