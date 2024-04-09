package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ2012_등수_매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
//        int min = A[0];
        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.abs(A[i] - (i + 1));
        }

        System.out.println(answer);

    }
}
