package com.backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A, Collections.reverseOrder());

        int max = A[0];

        for (int i = 1; i < N; i++) {
            int current = A[i] * (i + 1);
            if (max < current) max = current;

        }

        System.out.println(max);
    }
}
