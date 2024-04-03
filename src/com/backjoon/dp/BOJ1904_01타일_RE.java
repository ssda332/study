package com.backjoon.dp;

import java.util.*;

public class BOJ1904_01타일_RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N + 2];
        DP[1] = 1; DP[2] = 2;

        for (int i = 3; i <= N; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 15746;
        }

        System.out.println(DP[N]);
    }
}
