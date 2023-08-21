package com.backjoon.recursive;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        recursive(N);
        System.out.println();

        int M = sc.nextInt();
        int result = recursive2(M, 1);
        System.out.println(result);
    }

    static void recursive(int N) {
        if (N >= 1) {
            System.out.print(N + " ");
            recursive(N - 1);
        }
    }

    static int recursive2(int M, int cnt) {
        if (cnt == M) return cnt;

        return cnt + recursive2(M, cnt + 1);
    }
}
