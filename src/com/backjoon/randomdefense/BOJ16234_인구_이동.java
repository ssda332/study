package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ16234_인구_이동 {

    static int N;
    static int[] A;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;

        for (int i = 1; i < N; i++) {
            int length = A[i] - A[i - 1];
            gcd = gcd(length, gcd);
        }

        System.out.println((A[N - 1] - A[0]) / gcd - (N - 1));


    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
