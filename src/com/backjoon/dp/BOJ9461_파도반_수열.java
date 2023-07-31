package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461_파도반_수열 {
    public static void main(String[] args) throws IOException {
        // D[i] = D[i - 2] + D[i - 3]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            long[] D = new long[N + 3];

            D[1] = 1;
            D[2] = 1;
            D[3] = 1;

            for (int j = 4; j <= N; j++) {
                D[j] = D[j - 2] + D[j - 3];
            }

            sb.append(D[N] + "\n");
        }

        System.out.println(sb);
    }
}
