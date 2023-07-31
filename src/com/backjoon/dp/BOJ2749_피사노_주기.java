package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2749_피사노_주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pisano = 1500000;
        int N = (int)(Long.parseLong(br.readLine()) % pisano);

        long[] D = new long[pisano + 1];

        D[0] = 0;
        D[1] = 1;
        for(int i = 2 ; i < pisano && i <= N ; i++){
            D[i] = (D[i - 1] + D[i - 2]) % 1000000;
        }

        if (N >= pisano) {
            N %= pisano;
        }

        System.out.println(D[N]);

    }

}
