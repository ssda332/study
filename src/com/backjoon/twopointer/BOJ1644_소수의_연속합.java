package com.backjoon.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1644_소수의_연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean[] A = new boolean[N + 1];

        for (int i = 2; i < Math.sqrt(N); ) {
            if (A[i]) continue;
            for (int j = i; j <= N; j++) {
                if (j % i == 0) {
                    A[j] = true;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
/*
        for (int i = 2; i <= N; i++) {
            if (A[i] != 0) {
                list.add(A[i]);
            }
        }
*/


    }
}
