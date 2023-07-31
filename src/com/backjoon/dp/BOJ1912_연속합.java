package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] D = new int[N];
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = A[0];
        D[0] = A[0];

        for (int i = 1; i < N; i++) {
            D[i] = Math.max(D[i - 1] + A[i], A[i]);
            max = Math.max(D[i], max);
        }

        System.out.println(max);
    }
}
