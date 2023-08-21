package com.backjoon.math;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11050_이항_계수_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

//        System.out.println(pactorial(N, K));
        long[][] D = new long[1001][1001];

        // 2번 성질 (n == k)
        for (int i = 0; i <= K; i++) {
            D[i][i] = 1;
        }

        // 2번 성질 (k == 0)
        for(int i = 0; i <= N; i++) {
            D[i][0] = 1;
        }

        for (int i = 2; i <= 1000; i++) {
            for (int j = 1; j <= i; j++) {
                D[i][j] = (D[i - 1][j] + D[i - 1][j - 1]) % 10007L;
            }
        }

        System.out.println(D[N][K]);
    }

/*    static int pactorial(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }

        return (pactorial(n - 1, k) + pactorial(n - 1, k - 1)) % 10007;
    }*/
}
