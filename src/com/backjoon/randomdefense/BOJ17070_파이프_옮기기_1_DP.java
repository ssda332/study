package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070_파이프_옮기기_1_DP {

    static int N;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][N + 1];
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // D[i][j][k] = k번째 방법으로 파이프를 놓고 i,j 에 도달하는 경우의수 총합 k = 1 가로 2 대각선 3 세로
        // D[i][j][1] = D[i][j - 1][1] + D[i][j - 1][2]
        // D[i][j][2] = D[i - 1][j - 1][1] + D[i - 1][j - 1][2] + D[i - 1][j - 1][3]
        // D[i][j][3] = D[i - 1][j][2] + D[i - 1][j][3]
        int[][][] D = new int[N][N][3];

        D[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (A[i][j] == 1) continue;
                D[i][j][0] = D[i][j - 1][0] + D[i][j - 1][1];
                if (i == 0) continue;
                D[i][j][2] = D[i - 1][j][1] + D[i - 1][j][2];
                D[i][j][1] = D[i - 1][j - 1][0] + D[i - 1][j - 1][1] + D[i - 1][j - 1][2];
            }
        }

        System.out.println(D[N][N][0] + D[N][N][1] + D[N][N][2]);
    }
}

