package com.backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2023_신기한_소수 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);


    }

    static void DFS(int n, int d) {
        if (d == N) {
            if (isPrime(n)) {
                System.out.println(n);
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) {
                continue;
            }

            if (isPrime(n * 10 + i)) {
                DFS(n * 10 + i, d + 1);
            }
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
