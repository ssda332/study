package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ1915_가장_큰_정사각형_RE_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] A = new int[n + 1][m + 1];
        int[][] DP = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                A[i][j] = s.charAt(j - 1) - '0';
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i][j] == 1) DP[i][j] = Math.min(DP[i - 1][j - 1], Math.min(DP[i][j - 1], DP[i - 1][j])) + 1;
                if (DP[i][j] > answer) answer = DP[i][j];
            }
        }

        System.out.println(answer * answer);
    }
}
