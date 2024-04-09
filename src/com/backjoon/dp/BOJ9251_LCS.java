package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ9251_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int N = s1.length();
        int M = s2.length();

        int[][] DP = new int[N + 1][M + 1];
        int max = 0;


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) DP[i][j] = DP[i - 1][j - 1] + 1;
                else DP[i][j] = Math.max(DP[i][j - 1], DP[i - 1][j]);
                if (DP[i][j] > max) max = DP[i][j];
            }
        }

        System.out.println(max);
    }
}
