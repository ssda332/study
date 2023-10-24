package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149_RGB거리 {

    static int[] R;
    static int[] G;
    static int[] B;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        R = new int[N + 1];
        G = new int[N + 1];
        B = new int[N + 1];
        D = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        // D[i][j] : i번째 집을 j번 색으로 색칠했을때 최소값
        // D[i][2] = B[i] + min(D[i-1][0], D[i-1],[1])
        // 초기값
        // D[1][0] = R[1], D[1][1] = G[1], D[1][2] = B[1]

        D[1][0] = R[1];
        D[1][1] = G[1];
        D[1][2] = B[1];

        System.out.println(DP(N));
    }

    static int DP(int N) {
        return Math.min(Math.min(DP(N, 0), DP(N, 1)), DP(N, 2));
    }

    static int DP(int N, int rgb) {

        if (D[N][rgb] > 0) {
            return D[N][rgb];
        }

        if (rgb == 0) {
            D[N][rgb] = R[N] + Math.min(DP(N - 1, 1), DP(N - 1, 2));
        }else if (rgb == 1) {
            D[N][rgb] = G[N] + Math.min(DP(N - 1, 0), DP(N - 1, 2));
        }else {
            D[N][rgb] = B[N] + Math.min(DP(N - 1, 0), DP(N - 1, 1));
        }









        return D[N][rgb];

    }
}
