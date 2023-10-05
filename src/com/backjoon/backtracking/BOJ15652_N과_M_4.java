package com.backjoon.backtracking;

import java.util.Scanner;

public class BOJ15652_N과_M_4 {

    static int[] A;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

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

        for (int i = v; i <= N; i++) {
            dfs(i, depth + 1);
        }

    }
}
