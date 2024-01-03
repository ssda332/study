package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ18870_좌표_압축_RE {

    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        B = Arrays.stream(A).distinct().sorted().toArray();

        for (int i = 0; i < N; i++) {
            int target = A[i];
            int result = binarySearch(target);
            sb.append(result).append(" ");
        }

        System.out.println(sb);

    }

    static int binarySearch(int target) {
        int start = 0;
        int end = B.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (B[mid] > target) {
                end = mid - 1;
            } else if (B[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
