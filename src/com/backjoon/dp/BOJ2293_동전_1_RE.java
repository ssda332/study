package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ2293_동전_1_RE {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] DP = new int[K + 1];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        DP[0] = 1;

        /*for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                if (i - A[j] >= 0) {
                    DP[i] += DP[i - A[j]];
                }
            }
        }*/

        // 위와 같은 방법은 중복을 고려하지 않았음

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= A[i]) DP[j] += DP[j - A[i]];
            }
        }

        System.out.println(DP[K]);
    }
}
