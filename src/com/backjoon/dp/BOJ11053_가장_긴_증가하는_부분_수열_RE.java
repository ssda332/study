package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ11053_가장_긴_증가하는_부분_수열_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] D = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            D[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) D[i] = Math.max(D[i], D[j] + 1);
            }
        }

        int answer = Arrays.stream(D).max().getAsInt();
        System.out.println(answer);
    }
}
