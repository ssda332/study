package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932_정수_삼각형 {

    static int[][] A = new int[501][501];
    static int[][] D = new int[501][501];

    public static void main(String[] args) throws IOException {
        // D[i] = i번쨰 수까지 진행했을때 최대값

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                D[i][j] = -1;
            }
        }

        D[0][0] = A[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    D[i][j] = D[i - 1][j] + A[i][j];
                }else {
                    D[i][j] = Math.max(D[i - 1][j] + A[i][j], D[i - 1][j - 1] + A[i][j]);
                }

            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, D[N - 1][i]);
        }

        System.out.println(max);

    }

}
