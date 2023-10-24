package com.backjoon.backtracking;

import java.io.*;
import java.util.*;

public class BOJ15649_N과_M_1_RE_3 {

    static int N;
    static int M;
    static int[] A;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int v, int depth) {
        visited[v] = true;
        A[depth] = v;
        if (depth == M) {
            for (int i = 1; i <= M; i++) {
                sb.append(A[i]).append(" ");
            }
            visited[v] = false;
            sb.append("\n");
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
