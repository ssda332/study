package com.backjoon.dp;

import java.io.*;

public class BOJ2156_포도주_시식_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 3];
        int[] D = new int[N + 3];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // D[i] = max(D[i - 3] + A[i - 1] + A[i], D[i - 2] + A[i], D[i - 1])

        D[0] = A[0];
        D[1] = A[0] + A[1];
        D[2] = Math.max(Math.max(D[0] + A[2], D[1]), A[1] + A[2]);
        for (int i = 3; i < N; i++) {
            D[i] = Math.max(D[i - 1], Math.max(D[i - 3] + A[i - 1], D[i - 2]) + A[i]);
        }

        System.out.println(D[N - 1]);

    }
}
