package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15719_중복된_숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int e = Integer.parseInt(st.nextToken());
            A[e]++;
        }

        for (int i = 1; i <= N; i++) {
            if (A[i] > 1) {
                System.out.println(i);
            }
        }

        if (A[N] == 1) {
            System.out.println(N);
        }

    }
}
