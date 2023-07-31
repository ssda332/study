package com.backjoon.dp;

import java.io.*;

public class BOJ1463_1로_만들기 {

    static Integer[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        D = new Integer[N + 3];

        D[1] = 0;
        D[2] = 1;
        D[3] = 1;

        System.out.println(DP(N));
        br.close();
    }

    static int DP(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return D[n];
        }

        if (n % 6 == 0) {
            D[n] = Math.min(DP(n - 1), Math.min(DP(n / 3), DP(n / 2))) + 1;
        }else if (n % 3 == 0) {
            D[n] = Math.min(DP(n / 3) + 1, DP(n - 1) + 1);
        }else if (n % 2 == 0) {
            D[n] = Math.min(DP(n / 2) + 1, DP(n - 1) + 1);
        }else {
            D[n] = DP(n - 1) + 1;
        }

        return D[n];
    }



}
