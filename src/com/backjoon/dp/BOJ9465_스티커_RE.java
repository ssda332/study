package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ9465_스티커_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] A = new int[N + 1][3];
            int[][] DP = new int[N + 1][3];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                A[i][1] = Integer.parseInt(st1.nextToken());
                A[i][2] = Integer.parseInt(st2.nextToken());
            }

            // DP[i][1] = Max(DP[i - 1][2], DP[i - 2][1], DP[i - 2][2]) + A[i][1]
            // DP[i][2] = Max(DP[i - 1][1], DP[i - 2][1], DP[i - 2][2]) + A[i][2]

            DP[1][1] = A[1][1]; DP[1][2] = A[1][2];

            for (int i = 2; i <= N; i++) {
                DP[i][1] = Math.max(DP[i - 1][2], Math.max(DP[i - 2][1], DP[i - 2][2])) + A[i][1];
                DP[i][2] = Math.max(DP[i - 1][1], Math.max(DP[i - 2][1], DP[i - 2][2])) + A[i][2];
            }

            sb.append(Math.max(DP[N][1], DP[N][2])).append("\n");

        }

        System.out.println(sb);
    }
}
