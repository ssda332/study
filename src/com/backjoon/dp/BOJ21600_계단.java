package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ21600_계단 {
    public static void main(String[] args) throws IOException {

        // D[i] : i번째 계단에 왔을때 가장 긴 계단 길이
        // 초기값 D[0] = 1;
        // D[i] = D[i - 1] + 1 (A[i] > D[i - 1])
        // D[i] = A[i] (A[i] <= D[i - 1])

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] D = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        D[0] = 1;
        int max = 1;

        for (int i = 1; i < N; i++) {
            if (A[i] > D[i - 1]) {
                D[i] = D[i - 1] + 1;
            } else {
                D[i] = A[i];
            }

            if (D[i] > max) max = D[i];
        }

        System.out.println(max);

    }
}
