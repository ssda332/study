package com.backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stA.nextToken());
            B[i] = Integer.parseInt(stB.nextToken());
        }

        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += A[i] * B[i];
        }

        System.out.println(ans);
    }
}
