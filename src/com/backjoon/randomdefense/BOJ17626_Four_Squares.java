package com.backjoon.randomdefense;

import java.util.*;

public class BOJ17626_Four_Squares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N + 1];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[0] = 0; D[1] = 1;

        /*  D[1] = 1^2
            D[2] = 1^2 + 1^2
            D[3] = 1^2 + 1^2 + 1^2
            D[4] = 2^2
            D[5] = 2^2 + 1^2
            D[6] = 2^2 + 1^2 + 1^2
            D[7] = 2^2 + 1^2 + 1^2 + 1^2
            D[8] = 2^2 + 2^2

            D[i] = D[i - 1]
         */

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                D[i] = Math.min(D[i], D[i-j*j]);
            }

            D[i] += 1;
        }

        System.out.println(D[N]);

    }
}
