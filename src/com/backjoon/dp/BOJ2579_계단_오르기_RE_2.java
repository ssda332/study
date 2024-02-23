package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579_계단_오르기_RE_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] DP = new int[N][2];

        // 0 전 계단을 밟은경우 1 전 계단을 밟지않은경우
        // DP[i][0] : Math.max(DP[i - 1][1], DP[i - 2][0]) + A[i];
        // DP[i][1] : Math.max(DP[i - 2][0], DP[i - 2][1]) + A[i];

//        DP[0][0] =
    }
}
