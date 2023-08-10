package com.backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650_N과_M_2 {

    static int[] A;
    static boolean[] visited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
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
                sb.append(A[i] + " ");
                if (i == M) {
                    sb.append("\n");
                }
            }
            visited[v] = false;
            return;
        }
        for (int i = v + 1; i <= N; i++) {
            if (depth < M && !visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
            }
        }

        visited[v] = false;
    }
}
