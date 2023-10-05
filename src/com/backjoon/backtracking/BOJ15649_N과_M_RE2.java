package com.backjoon.backtracking;

import java.util.*;

public class BOJ15649_N과_M_RE2 {

    static int[] A;
    static boolean[] visited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[M + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            dfs(i, 1);
        }
        System.out.println(sb);

    }

    static void dfs(int v, int depth) {
        visited[v] = true;
        A[depth] = v;

        if (depth == M) {
            for (int i = 1; i <= M; i++) {
                    sb.append(A[i]).append(" ");
            }
            sb.append("\n");
            visited[v] = false;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

        visited[v] = false;
    }
}
