package com.backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649_N과_M_1_RE {
    static int[] A;
    static int N;
    static int M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 777
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
