package com.backjoon.backtracking;

import java.io.*;
import java.util.*;

public class BOJ15654_N과_M_5 {

    static int N;
    static int M;
    static int[] A;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parse(st.nextToken());
        M = parse(st.nextToken());
        A = new int[N + 1];
        visited = new boolean[N + 1];
        ans = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = parse(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 1; i <= N; i++) {
            dfs(i, 1);
        }

        System.out.println(sb);

    }

    static void dfs(int v, int depth) {
        visited[v] = true;
        ans[depth] = A[v];

        if (depth == M) {
            for (int i = 1; i <= M; i++) {
                sb.append(ans[i]).append(" ");
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

    static int parse(String line) {
        return Integer.parseInt(line);
    }
}
