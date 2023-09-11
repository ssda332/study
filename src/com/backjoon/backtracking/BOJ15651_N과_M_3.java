package com.backjoon.backtracking;

import java.io.*;
import java.util.*;

public class BOJ15651_N과_M_3 {

    static int[] A;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 777
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            dfs(i, 1);
        }
        System.out.println(sb);
    }

    static void dfs(int v, int depth) {
        A[depth] = v;

        if (depth == M) {
            for (int i = 1; i <= M; i++) {
                sb.append(A[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
                dfs(i, depth + 1);
        }

    }
}
