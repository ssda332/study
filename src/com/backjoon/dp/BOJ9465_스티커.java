package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ9465_스티커 {

    static StringBuilder sb = new StringBuilder();
    static int[][] D;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] A = new int[2][n];

            StringTokenizer st0 = new StringTokenizer(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                A[0][i] = Integer.parseInt(st0.nextToken());
                A[1][i] = Integer.parseInt(st1.nextToken());
            }

            // D[i][j] : i개의 스티커중에서 고를수 있는 최댓값 (j == 0 i번째에서 0행을 고름 1 1행을 고름 2 아무것도 고르지 않음)
            // D[i][0] = Max(D[i - 1][1], D[i - 1][2]) + A[0][i]
            // D[i][1] = Max(D[i - 1][0], D[i - 1][2]) + A[1][i]
            // D[i][2] = Max(D[i - 1][0], D[i - 1][1], D[i - 1][2])

            D = new int[n][3];
            D[0][0] = A[0][0]; D[0][1] = A[1][0];

            for (int i = 1; i < n; i++) {
                D[i][0] = Math.max(D[i - 1][1], D[i - 1][2]) + A[0][i];
                D[i][1] = Math.max(D[i - 1][0], D[i - 1][2]) + A[1][i];
                D[i][2] = Math.max(Math.max(D[i - 1][0], D[i - 1][1]), D[i - 1][2]);
            }

            int max = Math.max(Math.max(D[n - 1][0], D[n - 1][1]), D[n - 1][2]);

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
