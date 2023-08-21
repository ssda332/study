package com.backjoon.dp;

import java.util.Scanner;

public class BOJ2156_포도주_시식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N + 1];
        int[][] D = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        // D[i][0] : oxo i-2번째 포도주부터 i번째 포도주까지 먹은 여부
        // D[i][1] : xoo i-2번째 포도주부터 i번째 포도주까지 먹은 여부
        // D[i][2] : oox i-2번째 포도주부터 i번째 포도주까지 먹은 여부

        // 틀린 이유 : 마지막 포도주를 먹을수도 있고 안먹을수도 있다는 조건이 점화식에 포함되지 않았음.

        D[1][0] = D[1][1] = A[1]; D[1][2] = 0;
        if (N > 1) {
            D[2][0] = A[2]; D[2][1] = A[1] + A[2];
            D[2][2] = A[1];
        }

        for (int i = 3; i <= N; i++) {
            D[i][0] = Math.max(Math.max(D[i - 2][0], D[i - 2][1]), D[i - 2][2]) + A[i];
            D[i][1] = D[i - 1][0] + A[i];
            D[i][2] = D[i - 1][1];
        }

        System.out.println(Math.max(Math.max(D[N][0], D[N][1]), D[N][2]));
    }
}
