package com.backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1644_소수의_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] A = new boolean[N + 2];

        A[0] = A[1] = true;

        for (int i = 2; i < N; i++) {
            if (!A[i]) {
                for (int j = i * i; j <= N; j += i) {
                    if (j % i == 0) {
                        A[j] = true;
                    }
                }
            }
        }

        int start = 2;
        int end = 2;
        int sum = 2;
        int cnt = 0;

        while (end <= N) {
//            System.out.println("start : " + start + ", end : " + end);
            if (sum < N) {
                end++;
                while (A[end] && end < N) {
                    end++;
                }

                if (!A[end]) {
                    sum += end;
                }
            } else if (sum == N) {
                cnt++;
                end++;
                while (A[end] && end < N) {
                    end++;
                }

                if (!A[end]) {
                    sum += end;
                }
            } else {
                sum -= start;
                start++;
                while (A[start]) {
                    start++;
                }

            }
        }

        System.out.println(cnt);

    }
}
