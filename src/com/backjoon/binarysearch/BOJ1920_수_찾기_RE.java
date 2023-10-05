package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1920_수_찾기_RE {

    static int N;
    static int M;
    static int[] A;
    static int[] B;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(i)).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int n) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (A[middle] > B[n]) {
                right = middle - 1;
            } else if (A[middle] < B[n]){
                left = middle + 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
