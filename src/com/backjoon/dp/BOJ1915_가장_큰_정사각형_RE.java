package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ1915_가장_큰_정사각형_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] A = new int[n + 1][m + 1];
        int[][] DP = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                A[i][j] = str.charAt(j - 1) - '0';
            }
        }

        // DP
        // if (A[i][j] == 1) DP[i][j] = min(DP[i - 1][j], DP[i][j - 1], DP[i - 1][j - 1]) + 1
        // else DP[i][j] == 0

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i][j] == 1) {
                    DP[i][j] = Math.min(Math.min(DP[i - 1][j], DP[i][j - 1]), DP[i - 1][j - 1]) + 1;
                    if (answer < DP[i][j]) answer = DP[i][j];
                }
            }
        }

        System.out.println(answer * answer);
    }
}
