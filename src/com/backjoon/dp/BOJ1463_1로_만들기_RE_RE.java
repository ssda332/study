package com.backjoon.dp;

import java.io.*;

public class BOJ1463_1로_만들기_RE_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 1];
        // D[i] = i일때 연산 최소값
        if (N == 1) {
            System.out.println(0);
            return;
        }
        D[2] = 1;
        for (int i = 3; i <= N; i++) {
            if (i % 6 == 0) {
                D[i] = Math.min(Math.min(D[i / 3], D[i / 2]), D[i - 1]) + 1;
            } else if (i % 3 == 0) {
                D[i] = Math.min(D[i / 3], D[i - 1]) + 1;
            } else if (i % 2 == 0) {
                D[i] = Math.min(D[i / 2], D[i - 1]) + 1;
            } else {
                D[i] = D[i - 1] + 1;
            }
        }

        System.out.println(D[N]);

    }
}
