package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11722_가장_긴_감소하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(D, 1);
        // D[i] = i번째까지의 수열에서 가장 긴 감수하는 부분 수열의 길이
        // D[i] = D[j] + 1
        // 10 30 10 20 20 10
        // 1 1 2

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] < A[j] && D[j] + 1 > D[i]) {
                    D[i] = D[j] + 1;
                }
            }
        }

        int max = Arrays.stream(D)
                .max().getAsInt();
        System.out.println(max);
//        Arrays.stream(D)
//                .forEach(System.out::println);

    }
}
