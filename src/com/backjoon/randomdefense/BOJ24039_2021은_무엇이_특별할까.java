package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ24039_2021은_무엇이_특별할까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] A = new boolean[10001];

        A[0] = A[1] = true;

        for (int i = 2; i <= N; i++) {
            if (A[i]) continue;
            for (int j = i * i; j <= N; j = j += i) {
                if (j % i == 0) {
                    A[j] = true;
                }
            }
        }

        int num1 = 2;
        int num2 = 3;

        if (N < 6) {
            System.out.println(6);
        } else {
            for (int i = 5; i <= N; i++) {
                if (!A[i]) {
                    num1 = num2;
                    num2 = i;
                    int sum = num1 * num2;
                    if (sum > N) {
                        System.out.println(sum);
                        break;
                    }
                }
            }
        }
    }
}
