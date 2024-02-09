package com.backjoon.dp;

import java.util.*;

public class BOJ9657_돌_게임_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N + 5];


        D[1] = 1; D[2] = 0; D[3] = 1; D[4] = 1; D[5] = 1;

        for (int i = 6; i <= N; i++) {
            if(D[i - 1] + D[i - 3] + D[i - 4] < 3) D[i] = 1;
            else D[i] = 0;
        }

        if (D[N] == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}
