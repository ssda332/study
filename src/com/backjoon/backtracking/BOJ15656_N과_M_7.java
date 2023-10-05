package com.backjoon.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656_N과_M_7 {

    static int N;
    static int M;
    static int[] A;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        ans = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 1; i <= N; i++) {
            dfs(i, 1);
        }

        System.out.println(sb);
    }

    static void dfs(int v, int depth) {
        ans[depth] = A[v];

        if (depth == M) {
            for (int i = 1; i <= M; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = v; i <= N; i++) {
            dfs(i, depth + 1);
        }
    }
}
