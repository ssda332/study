package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055_가장_큰_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] D = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        D[0] = A[0];
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < N; i++) {
            D[i] = A[i];

            for (int j = i - 1; j >= 0; j--) {
                int current = D[j] + A[i];

                if (A[i] > A[j] && current > D[i]) {
                    D[i] = current;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (D[i] > result) result = D[i];
        }

        System.out.println(result);

    }
}
