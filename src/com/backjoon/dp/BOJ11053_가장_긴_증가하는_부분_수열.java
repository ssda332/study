package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ11053_가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] D = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        D[0] = 1;
        // D[i] = i번째까지의 부분수열 중에서 가장 긴 길이

        /*for (int i = 1; i < N; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && max < D[j]) {
                    max = D[j];
                }
            }

            D[i] = max + 1;
        }*/
        for (int i = 1; i < N; i++) {
            D[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && D[i] < D[j] + 1) {
                    D[i] = D[j] + 1;
                }
            }
        }

        int answer = Arrays.stream(D).max().getAsInt();
        System.out.println(answer);


    }
}
