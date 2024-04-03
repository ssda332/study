package com.backjoon.dp;

import java.util.*;

public class BOJ11057_오르막_수_RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] DP = new int[N + 1][10];

        Arrays.fill(DP[1], 1);

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    DP[i][j] = (DP[i][j] + DP[i - 1][k]) % 10007;
                }
            }
        }

        System.out.println(Arrays.stream(DP[N]).sum() % 10007);
    }
}
