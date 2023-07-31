package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463_1로_만들기_BUTTOM_UP {
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        A[1] = 0;

        for (int i = 2; i <= N; i++) {
            A[i] = A[i - 1] + 1;
            if (i % 2 == 0) {
                A[i] = Math.min(A[i], A[i / 2] + 1);
            }
            if (i % 3 == 0) {
                A[i] = Math.min(A[i], A[i / 3] + 1);
            }
        }

        System.out.println(A[N]);
    }

}
