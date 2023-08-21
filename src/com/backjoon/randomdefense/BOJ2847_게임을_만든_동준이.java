package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2847_게임을_만든_동준이 {
    public static void main(String[] args) throws IOException {
        // 12:15
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int max = A[N];
        int count = 0;
        for (int i = N - 1; i >= 1; i--) {
            if (A[i] >= A[i + 1]) {
                while (A[i] + 1 != A[i + 1]) {
                    A[i] -= 1;
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
