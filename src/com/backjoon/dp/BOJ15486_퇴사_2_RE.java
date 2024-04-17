package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ15486_퇴사_2_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] DP = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            T[i] = t;
            P[i] = p;
        }

        // DP[i] = i일날부터 n날까지 일하고 얻을수 있는 최대 수익
        if (T[N] == 1) {
            DP[N] = P[N];
        }

        for (int i = N - 1; i > 0; i--) {
            if (N - i + 1 < T[i]) {
                DP[i] = DP[i + 1];
            } else {
                DP[i] = Math.max(DP[i + 1], DP[i + T[i]] + P[i]);
            }
        }

        System.out.println(DP[1]);
    }
}
