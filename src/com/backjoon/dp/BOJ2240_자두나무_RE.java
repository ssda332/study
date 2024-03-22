package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ2240_자두나무_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] jadu = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            jadu[i] = Integer.parseInt(br.readLine());
        }

        int[][][] DP = new int[3][T + 1][W + 2];
        // DP[P][T][W] : 자두가 P에 있고 T초동안 W번 움직였을때 받을 수 있는 최대 자두
        // for T
        // if 자두가 1번에서 떨어질떄
        // DP[1][T][W] = Max(DP[1][T - 1][W], DP[2][T - 1][W - 1]
        // DP[2][T][W] = Max(DP[1][T - 1][W - 1], DP[2][T - 1][W - 1]
        // if 자두가 2번에서 떨어질떄
        // DP[1][T][W] = Max(DP[1][T - 1][W - 1], DP[2][T - 1][W - 1]
        // DP[2][T][W] = Max(DP[1][T - 1][W], DP[2][T - 1][W - 1]

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (jadu[i] == 1) {
                    DP[1][i][j] = Math.max(DP[1][i - 1][j] + 1, DP[2][i - 1][j - 1] + 1);
                    DP[2][i][j] = Math.max(DP[1][i - 1][j - 1], DP[2][i - 1][j]);
                } else {
                    if (i == 1 && j == 1) continue;
                    DP[1][i][j] = Math.max(DP[1][i - 1][j], DP[2][i - 1][j - 1]);
                    DP[2][i][j] = Math.max(DP[1][i - 1][j - 1] + 1, DP[2][i - 1][j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= W + 1; i++) {
            result = Math.max(result, Math.max(DP[1][T][i], DP[2][T][i]));
        }

        System.out.println(result);
    }
}
