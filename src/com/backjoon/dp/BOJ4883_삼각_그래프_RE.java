package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ4883_삼각_그래프_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (true) {
            int T = Integer.parseInt(br.readLine());
            if (T == 0) break;
            idx++;

            int[][] A = new int[3][T];
            int[][] DP = new int[3][T];

            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    A[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            DP[0][0] = Integer.MAX_VALUE; DP[1][0] = A[1][0]; DP[2][0] = A[1][0] + A[2][0]; DP[0][1] = A[1][0] + A[0][1];

            for (int i = 1; i < T; i++) {
                DP[0][i] = Math.min(DP[0][i - 1], DP[1][i - 1]) + A[0][i];
                DP[1][i] = Math.min(DP[0][i], Math.min(DP[2][i - 1], Math.min(DP[1][i - 1], DP[0][i - 1]))) + A[1][i];
                DP[2][i] = Math.min(Math.min(DP[1][i], DP[1][i - 1]), DP[2][i - 1]) + A[2][i];
            }

            sb.append(idx).append(". ").append(DP[1][T - 1]).append("\n");
        }

        System.out.println(sb);

    }
}
