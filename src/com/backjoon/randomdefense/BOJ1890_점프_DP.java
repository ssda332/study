package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1890_점프_DP {

    static int N;
    static int[][] A;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        StringTokenizer st;

        long[][] D = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                A[i][j] = num;
            }
        }

        D[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 아래로 점프했을 경우
                for (int k = i - 1; k >= 0; k--) {
                    if (A[k][j] + k == i) {
                        D[i][j] += D[k][j];
                    }
                }

                // 오른쪽으로 점프했을 경우
                for (int k = j - 1; k >= 0; k--) {
                    if (A[i][k] + k == j) {
                        D[i][j] += D[i][k];
                    }
                }
            }
        }

        // D[i][j] : i, j 번째에 도달할 수 있는 경우의수

        System.out.println(D[N - 1][N - 1]);


    }
}
