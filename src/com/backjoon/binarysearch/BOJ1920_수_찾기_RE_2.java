package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1920_수_찾기_RE_2 {

    static int N;
    static int[] A;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            int answer = binarySearch(num);
            sb.append(answer).append("\n");

        }

        System.out.println(sb);


    }

    static int binarySearch(int num) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (A[middle] > num) {
                right = middle - 1;
            } else if (A[middle] < num) {
                left = middle + 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
