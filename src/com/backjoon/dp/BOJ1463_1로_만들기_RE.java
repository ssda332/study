package com.backjoon.dp;

import java.util.Scanner;

public class BOJ1463_1로_만들기_RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // D[i] = N이 i가 되는 최소 연산개수
        // if (N % 6 == 0) D[i] = min(min(D[i / 3] + 1, D[i / 2] + 1), D[i - 1] + 1)
        // elsif (N % 3 == 0) min(D[i / 3] + 1, D[i - 1] + 1)
        // elsif (N % 2 == 0) min(D[i / 2] + 1, D[i - 1] + 1)

        //
        int[] D = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            if (i % 6 == 0) {
                D[i] = Math.min(Math.min(D[i / 2] + 1, D[i / 3] + 1), D[i - 1] + 1);
            } else if (i % 3 == 0) {
                D[i] = Math.min(D[i / 3] + 1, D[i - 1] + 1);
            } else if (i % 2 == 0) {
                D[i] = Math.min(D[i / 2] + 1, D[i - 1] + 1);
            } else {
                D[i] = D[i - 1] + 1;
            }
        }

        System.out.print(D[N]);

    }
}
