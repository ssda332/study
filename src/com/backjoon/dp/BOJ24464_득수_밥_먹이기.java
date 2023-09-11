package com.backjoon.dp;

import java.util.*;

public class BOJ24464_득수_밥_먹이기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] D = new long[N + 1][5];

        // D[i][j] : i일차에 j번째 식당을 갔을 때 점심 식단 총 경우의수 (0 = x, 1~4 번째 식당 방문)
        // D[1][0] = 1, D[1][1] = 1, D[1][2] = 1, D[1][3] = 1, D[1][4] = 1
        // D[i][0] = D[i - 1][1] + D[i - 1][2] + D[i - 1][3] + D[i - 1][4]
        // D[i][1] = D[i - 1][0] + D[i - 1][3] + D[i - 1][4]
        // D[i][2] = D[i - 1][0] + D[i - 1][4]
        // D[i][3] = D[i - 1][0] + D[i - 1][1]
        // D[i][4] = D[i - 1][0] + D[i - 1][1] + D[i - 1][2]

        D[1][0] = 1; D[1][1] = 1; D[1][2] = 1; D[1][3] = 1; D[1][4] = 1;
        for (int i = 2; i <= N; i++) {
            D[i][0] = (D[i - 1][1] + D[i - 1][2] + D[i - 1][3] + D[i - 1][4]) % 1000000007;
            D[i][1] = (D[i - 1][0] + D[i - 1][3] + D[i - 1][4]) % 1000000007;
            D[i][2] = (D[i - 1][0] + D[i - 1][4]) % 1000000007;
            D[i][3] = (D[i - 1][0] + D[i - 1][1]) % 1000000007;
            D[i][4] = (D[i - 1][0] + D[i - 1][1] + D[i - 1][2]) % 1000000007;
        }

        long sum = (D[N][0] + D[N][1] + D[N][2] + D[N][3] + D[N][4]) % 1000000007;
        System.out.println(sum);
    }
}
