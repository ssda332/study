package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193_이친수 {
    public static void main(String[] args) throws IOException {
        // D[i] = D[i - 2] + 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] D = new long[N + 1];

        D[1] = 1;
        D[2] = 1;

        for (int i = 3; i <= N; i++) {
            D[i] = D[i - 1] + D[i - 2];
        }

        System.out.println(D[N]);

    }
}
