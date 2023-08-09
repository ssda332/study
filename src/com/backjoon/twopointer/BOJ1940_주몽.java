package com.backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int start = 0;
        int end = A.length - 1;
        int cnt = 0;

        while (start < end) {
            int sum = A[start] + A[end];

            if (sum == M) {
                cnt++;
                start++;
                end--;
            } else if (sum > M) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(cnt);

    }
}
