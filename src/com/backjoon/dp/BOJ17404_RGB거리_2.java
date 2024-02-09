package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ17404_RGB거리_2 {

    private static final int INF = 1_000 * 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = INF;
        int[][] D = new int[N + 1][3]; // i번째 집을 j로 칠하는데 최소값
//        D[1][0] = A[1][0]; D[1][1] = A[1][1]; D[1][2] = A[1][2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) D[1][j] = A[1][j];
                else D[1][j] = INF;
            }

            for (int k = 2; k <= N; k++) {
                D[k][0] = Math.min(D[k - 1][1], D[k - 1][2]) + A[k][0];
                D[k][1] = Math.min(D[k - 1][0], D[k - 1][2]) + A[k][1];
                D[k][2] = Math.min(D[k - 1][0], D[k - 1][1]) + A[k][2];
            }

            for (int k = 0; k < 3; k++) {
                if (i != k) min = Math.min(min, D[N][k]);
            }
        }

        System.out.println(min);
    }
}
