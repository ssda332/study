package com.backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18870_좌표_압축 {

    static int N;
    static int[] A;
    static int[] B;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        B = Arrays.stream(A.clone()).distinct().sorted().toArray();

        for (int i = 0; i < N; i++) {
            int result = binarySearch(A[i]);
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    static int binarySearch(int target) {
        int left = 0;
        int right = B.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (B[mid] > target) {
                right = mid - 1;
            } else if (B[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
