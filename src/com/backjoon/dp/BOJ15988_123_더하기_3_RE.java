package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ15988_123_더하기_3_RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] DP = new long[1000001];
        DP[1] = 1; DP[2] = 2; DP[3] = 4;
        StringBuilder sb = new StringBuilder();

        for (int i = 4; i <= 1000000; i++) {
            DP[i] = (DP[i - 3] + DP[i - 2] + DP[i - 1]) % 1000000009;
        }

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();

            sb.append(DP[n]).append("\n");
        }

        System.out.println(sb);
    }
}
