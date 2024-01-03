package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1026_보물 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];
        int[] B = new int[N];
        int sum = 0;

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st1.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

//        int[] C = B.clone();
        Arrays.sort(B);
        Arrays.sort(A, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            sum += A[i] * B[i];
        }

        System.out.println(sum);

    }
}
