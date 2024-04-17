package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ9084_동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[] coins = new int[N];
            int[] DP = new int[M + 1];
            DP[0] = 1;

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (j >= coins[i]) DP[j] += DP[j - coins[i]];
                }
            }

            sb.append(DP[M]).append("\n");
        }

        System.out.println(sb);
    }
}
