package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ2212_센서 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] D = new int[N - 1];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            if (i >= 1) {
                D[i - 1] = A[i] - A[i - 1];
            }
        }

        Arrays.sort(D);

        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += D[i];
        }

        System.out.println(answer);



    }
}
