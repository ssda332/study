package com.backjoon.dp;

import java.util.*;

public class BOJ1788_피보나치_수의_확장 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] D = new int[1000001];
        int[] MD = new int[1000001];
        D[1] = 1;
        MD[1] = 1;
        for (int i = 2; i <= 1000000; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 1000000000;
        }

        // F(n) = F(n - 2) - F(n - 1)
        for (int i = 2; i <= 1000000; i++) {
            MD[i] = (MD[i - 2] - MD[i - 1]) % 1000000000;
        }

        if (n > 0) {
            printResult(D[n]);
        } else {
            printResult(MD[Math.abs(n)]);
        }

    }

    static void printResult(int answer) {
        if (answer > 0) System.out.println(1);
        else if (answer == 0) System.out.println(0);
        else System.out.println(-1);

        System.out.println(Math.abs(answer));
    }
}
