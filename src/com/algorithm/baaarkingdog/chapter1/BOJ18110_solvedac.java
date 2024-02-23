package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ18110_solvedac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int cut = (int)Math.round((double)N / 100 * 15);

        int sum = 0;
        Arrays.sort(A);
        for (int i = cut; i < N - cut; i++) {
            sum += A[i];
        }

        int answer = (int)Math.round((double)sum / (N - (2 * cut)));

        System.out.println(answer);

    }
}
