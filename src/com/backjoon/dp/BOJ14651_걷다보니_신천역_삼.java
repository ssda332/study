package com.backjoon.dp;

import java.util.*;
import java.io.*;

public class BOJ14651_걷다보니_신천역_삼 {

    static int N;
    static int[] A;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        small(1, 0);
        small(2, 0);

        System.out.println(cnt);

    }

    static void small(int v, int depth) {
        A[depth] = v;

        if (depth == N - 1) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
//                System.out.print(A[i] + " ");
                sum += A[i];
            }
//            System.out.println();

            if (sum % 3 == 0) cnt++;

            return;
        }

        for (int i = 0; i < 3; i++) {
//            System.out.println("i : " + i + ", depth : " + depth);
            small(i, depth + 1);
        }
    }
}
