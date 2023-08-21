package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11055_가장_큰_증가하는_부분_수열_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            D[i] = A[i];
        }

        // A[i] > A[j] <- 증가하는 수열이고 D[j] + 1 > D[i] 현재 i번까지의 조건 만족하는 수열 길이가 D[j] + 1보다 작아야함

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && D[j] + A[i] > D[i]) {
                    D[i] = D[j] + A[i];
                }
            }
        }


        int max = Arrays.stream(D)
                .max().getAsInt();
        System.out.println(max);
    }
}
