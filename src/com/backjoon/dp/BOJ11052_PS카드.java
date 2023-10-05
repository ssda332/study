package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ11052_PS카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N + 1];
        int[] D = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            D[i] = cards[i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                D[i] = Math.max(D[i], D[j] + cards[i - j]);
            }
        }

        System.out.println(D[N]);
        // D[2]  D[2], D[1]+A[1]
        // D[3] = Max(D[3], D[2] + A[1], D[1] + A[2])

        // D[i] = 카드를 i개 샀을때 최대값
        // D[i] = Max(D[i - 1] + cards[1] ... D[0] + cards[i])
    }
}
