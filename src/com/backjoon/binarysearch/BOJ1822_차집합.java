package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1822_차집합 {

    static int N;
    static int M;
    static int[] A;
    static int[] B;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            binarySearch(A[i]);
        }

        if (count == 0) {
            sb.append(count);
        } else {
            sb.insert(0, "\n").insert(0, count);
        }
        System.out.println(sb);

    }

    static void binarySearch(long target) {
        int lo = 0;
        int hi = M - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (target > B[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (B[lo] != target && B[hi] != target) {
            sb.append(target).append(" ");
            count++;
        }
    }
}
