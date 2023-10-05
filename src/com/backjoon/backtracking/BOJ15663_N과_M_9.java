package com.backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ15663_N과_M_9 {

    static int N;
    static int M;
    static int[] A;
    static int[] B;
    static boolean[] visited;
    static LinkedHashSet<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        B = new int[N + 1];
        visited = new boolean[N + 1];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 1; i <= N; i++) {
            dfs(i, 1);
        }

        ans.forEach(System.out::println);
    }

    static void dfs(int v, int depth) {
        B[depth] = A[v];
        visited[v] = true;

        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= M; i++) {
                sb.append(B[i]).append(" ");
            }

            ans.add(sb.toString());
            visited[v] = false;
            return;
        }

        for (int i = v; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

        visited[v] = false;
    }
}
