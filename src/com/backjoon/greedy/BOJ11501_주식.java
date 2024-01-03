package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ11501_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            int max = A[N - 1];

            for (int i = N - 2; i >= 0; i--) {
                if (max > A[i]) {
                    result += (max - A[i]);
                } else {
                    max = A[i];
                }
            }

            sb.append(result).append("\n");

        }

        System.out.println(sb);
    }
}
