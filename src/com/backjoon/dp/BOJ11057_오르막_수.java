package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ11057_오르막_수 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // D[i][j] : 뒷자리가 j이고 i자리수의 오르막수 개수
        // D[1] = 10, D[2] = 55, D[3] = 220
        // D[1][0] = 1 ... D[1][9] = 1
        // D[2][0] = D[1][0] + ... D[1][9]
        // D[2][9] = D[1][9]

        int[][] D = new int[N + 1][10];

        Arrays.fill(D[1], 1);

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    D[i][j] += D[i - 1][k];
                    D[i][j] %= 10007;
                }
            }
        }

        int sum = Arrays.stream(D[N]).sum();
        System.out.println(sum % 10007);

    }
}
