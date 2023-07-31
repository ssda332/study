package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2748_피보나치수_TOPDOWN {

    static long[] D;
    static long cnt1 = 1;
    static long cnt2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        D = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            D[i] = -1L;
        }

        D[0] = 0L;
        D[1] = 1L;
        D[2] = 1L;
        fibo(N);
        fib(N);

        System.out.println(cnt1 + " " + cnt2);
//        System.out.println(D[N]);

    }

    public static long fibo(int n) {
        if (D[n] != -1) {
            return D[n];
        } else {
            cnt2++;
            return D[n] = fibo(n - 1) + fibo(n - 2);
        }
    }

    public static long fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            cnt1++;
            return fib(n - 1) + fib(n - 2);
        }

    }
}
