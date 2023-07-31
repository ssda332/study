package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11727_2XN타일링_2 {
    public static void main(String[] args) throws IOException {
        // D[i] = 2xi 직사각형을 채우는 방법의 수
        // D[i] = D[i - 1] + D[i - 2] + D[i - 2]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] D = new long[N + 1];

        D[1] = 1;
        if (N > 1) D[2] = 3;

        for (int i = 3; i <= N; i++) {
            D[i] = (D[i - 1] + 2 * D[i - 2]) % 10007;
        }

        System.out.println(D[N]);



    }
}
