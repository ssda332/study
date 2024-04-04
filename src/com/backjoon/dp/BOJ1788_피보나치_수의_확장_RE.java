package com.backjoon.dp;

import java.util.*;

public class BOJ1788_피보나치_수의_확장_RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N = Math.abs(n);

        // F(-1) = 1
        // F(-2) = -1, F(-3) = 2, F(-4) = -3, F(-5) = 5, F(-6) = -8
        int[] DP = new int[N + 2];
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 1000000000;
        }

        if (n < 0 && N % 2 == 0) {
            System.out.println(-1);
        } else if (n == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

        System.out.println(DP[N]);
    }
}
