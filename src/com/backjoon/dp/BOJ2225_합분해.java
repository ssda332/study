package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ2225_합분해 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        final int MOD = 1000000000;

        int[][] DP = new int[K + 1][N + 1];
        Arrays.fill(DP[1], 1);

        for (int i = 1; i <= K; i++) {
            DP[i][0] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                DP[i][j] = (DP[i - 1][j] + DP[i][j - 1]) % MOD;
            }
        }

        System.out.println(DP[K][N]);
    }
}
