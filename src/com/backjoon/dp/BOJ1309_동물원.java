package com.backjoon.dp;

import java.util.Scanner;

public class BOJ1309_동물원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // D[i][3] : i번째 열까지 왔을때 사자를 배치하는 경우의수 0 사자 배치 x 1 왼쪽에 사자배치 2 오른쪽에 사자배치
        // D[i][0] = D[i - 1][0] + D[i - 1][1] + D[i - 1][2];
        // D[i][1] = D[i - 1][0] + D[i - 1][2];
        // D[i][2] = D[i - 1][0] + D[i - 1][1];

        int[][] D = new int[N + 1][3];

        D[1][0] = 1; D[1][1] = 1; D[1][2] = 1;

        for (int i = 2; i <= N; i++) {
             D[i][0] = (D[i - 1][0] + D[i - 1][1] + D[i - 1][2]) % 9901;
             D[i][1] = (D[i - 1][0] + D[i - 1][2]) % 9901;
             D[i][2] = (D[i - 1][0] + D[i - 1][1]) % 9901;
        }

        System.out.println((D[N][0] + D[N][1] + D[N][2]) % 9901);
    }
}
