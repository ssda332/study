package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501_퇴사 {

    static int[] D;
    static int[] T;
    static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] D = new int[N + 2];
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }


        // D[i] i일부터 퇴사날까지 일했을 때 받을수 있는 최대가격
        // D[i] = D[i + 1]
        // D[i] = MAX(D[i + 1], D[i + T[i]] + P[i])

        for (int i = N; i >= 1; i--) {
            if (N - i + 1 < T[i]) {
                D[i] = D[i + 1];
            }else {
                D[i] = Math.max(D[i + 1], D[i + T[i]] + P[i]);
            }
        }

        System.out.println(D[1]);

    }
}
