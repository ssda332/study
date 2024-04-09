package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ2293_동전_1_RE_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] DP = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        DP[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= coins[i]) DP[j] += DP[j - coins[i]];
            }
        }

        System.out.println(DP[k]);

    }
}
