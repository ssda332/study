package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2240_자두나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()); // t초동안 떨어지는 자두
        int W = Integer.parseInt(st.nextToken()); // 움직이는 횟수

        int[] jadu = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            jadu[i] = Integer.parseInt(br.readLine());
        }

        int[][][] D = new int[T + 1][W + 2][3];

        // D[i][j][1] = j번 움직이고 i초에 1번 나무에서 받을수있는 자두의 최대값
        // D[i][j][1] = max(D[i - 1][j][1] + 1, D[i - 1][j - 1][2] + 1)
        // D[i][j][2] = max(D[i - 1][j - 1][1] + 1, D[i - 1][j][2] + 1)

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (jadu[i] == 1) {
                    D[i][j][1] = Math.max(D[i - 1][j][1] + 1, D[i - 1][j - 1][2] + 1);
                    D[i][j][2] = Math.max(D[i - 1][j - 1][1], D[i - 1][j][2]);
                } else {
                    if (i == 1 && j == 1) continue;
                    D[i][j][1] = Math.max(D[i - 1][j][1], D[i - 1][j - 1][2]);
                    D[i][j][2] = Math.max(D[i - 1][j - 1][1] + 1, D[i - 1][j][2] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= W + 1; i++) {
            result = Math.max(result, Math.max(D[T][i][1], D[T][i][2]));
        }

        System.out.println(result);
    }
}
