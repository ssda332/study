package com.backjoon.recursive;

import java.util.Scanner;

public class BOJ11729_하노이_탑 {

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int N = sc.nextInt();

        System.out.println((int)Math.pow(2, N) - 1);
        hanoi(N, 1, 3);
        System.out.println(sb);
    }

    static void hanoi(int n, int a, int b) {
        // base condition
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }

        int mid = 6-a-b; // n - 1개의 원판이 위치할 기둥
        hanoi(n - 1, a, mid);
        sb.append(a).append(" ").append(b).append("\n");
        hanoi(n - 1, mid, b);

    }
}
