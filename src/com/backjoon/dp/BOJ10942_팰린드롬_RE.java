package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ10942_팰린드롬_RE {

    static int[] A;
    static boolean[][] DP;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        DP = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                DP[i][j] = checkPalindrome(i, j);
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (DP[s][e]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);

    }

    static boolean checkPalindrome(int s, int e) {
        if (visited[s][e]) return DP[s][e];
        visited[s][e] = true;

        if (s == e) return DP[s][e] = true;

        if (e - s > 1) {
            boolean flag = checkPalindrome(s + 1, e - 1);
            return DP[s][e] = (A[s] == A[e] && flag);
        } else {
            return DP[s][e] = (A[s] == A[e]);
        }

    }
}
