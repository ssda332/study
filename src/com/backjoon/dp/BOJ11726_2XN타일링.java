package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726_2XN타일링 {

    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        D = new int[N + 1];

        D[1] = 1;
        if (N > 1) {
            D[2] = 2;
        }

        System.out.println(DP(N));
    }

    public static int DP(int n) {
        if (D[n] > 0) {
            return D[n];
        }

        return D[n] = (DP(n - 1) + DP(n - 2)) % 10007;

    }
}
