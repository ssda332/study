package com.backjoon.string;

import java.util.*;

public class BOJ5582_공통_부분_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int N = s1.length();
        int M = s2.length();
        int[][] dp = new int[N + 1][M + 1];

        // dp[i][j] : i - 1번째 index까지의 string, j - 1번째 index까지의 string일때 가장 긴 공통부분 문자열의 길이

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1.substring(i - 1, i).equals(s2.substring(j - 1, j))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
