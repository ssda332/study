package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844_쉬운_계단_수 {

    static long[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // D[i][j] : j로 끝나는 N자리 수

        // D[i][j] = D[i - 1][j + 1] + D[i - 1][j - 1]
        // j == 0 D[i][j] = D[i - 1][j + 1]
        // j == 9 D[i][j] = D[i - 1][j - 1]

        D = new long[N + 1][10];
        D[1][1] = 1;
        D[1][2] = 1;
        D[1][3] = 1;
        D[1][4] = 1;
        D[1][5] = 1;
        D[1][6] = 1;
        D[1][7] = 1;
        D[1][8] = 1;
        D[1][9] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    D[i][j] = D[i - 1][j + 1] % 1000000000;
                }else if (j == 9) {
                    D[i][j] = D[i - 1][j - 1] % 1000000000;
                }else {
                    D[i][j] = D[i - 1][j + 1] % 1000000000 + D[i - 1][j - 1] % 1000000000;
                }
            }
        }

        long sum = 0;

        for (int i = 0; i <= 9; i++) {
            sum = (sum + D[N][i]) % 1000000000;
        }

        System.out.println(sum);

    }
}
