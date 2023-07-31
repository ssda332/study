package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1904_01타일 {

    public static void main(String[] args) throws IOException {
        // D[i][0] = 0으로 시작하는 크기가 i인 이진 수열의 가짓수
        // D[i][0] = D[i - 2][0] + D[i - 2][1]
        // D[i][1] = D[i - 1][0] + D[i - 1][1]
        // 초기값 i가 1하고 2일때만
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] D = new long[N + 1][2];

        D[1][0] = 0;
        D[1][1] = 1;
        if (N > 1) {
            D[2][0] = 1;
            D[2][1] = 1;
        }

        for (int i = 3; i <= N; i++) {
            D[i][0] = (D[i - 2][0] + D[i - 2][1]) % 15746;
            D[i][1] = (D[i - 1][0] + D[i - 1][1]) % 15746;
        }

        System.out.println((D[N][0] + D[N][1]) % 15746);
    }
}
