package com.backjoon.dp;

import java.util.*;

public class BOJ15624_피보나치_수_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] fibo = new int[N + 1];

        if (N == 0) {
            System.out.println(0);
            return;
        } else if (N == 1) {
            System.out.println(1);
            return;
        }

        fibo[0] = 0; fibo[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000007;
        }

        System.out.println(fibo[N]);
    }
}
