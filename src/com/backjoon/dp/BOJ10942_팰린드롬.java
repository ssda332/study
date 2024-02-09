package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ10942_팰린드롬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] DP = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) { //
                if (i == j) {
                    DP[j][i] = true;
                } else if (i == j + 1 && A[i] == A[j]) {
                    DP[j][i] = true;
                } else {
                    if (DP[j + 1][i - 1] && A[i] == A[j]) DP[j][i] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (DP[S - 1][E - 1]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}
