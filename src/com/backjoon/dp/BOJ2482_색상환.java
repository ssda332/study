package com.backjoon.dp;

import java.io.*;

public class BOJ2482_색상환 {

    static final int MOD = 1000000003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] DP = new int[N + 1][N + 1];

        // DP[i][j] : i개의 색 중에서 j개를 띄엄띄엄 고르는 가짓수
        // DP[i][j] = DP[i - 2][j - 1] + DP[i - 1][j]
        /*if (K == 1) {
            System.out.println(N);
            return;
        }*/

        for (int i = 1; i <= N; i++) {
            DP[i][1] = i;
            DP[i][0] = 1;
        }

        for (int i = 3; i <= N; i++) {
            for (int j = 2; j <= (i + 1) / 2; j++) {
                DP[i][j] = (DP[i - 1][j] + DP[i - 2][j - 1]) % MOD;
            }
        }

        int answer = (DP[N - 3][K - 1] + DP[N - 1][K]) % MOD;
        System.out.println(answer);
    }
}
