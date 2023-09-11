package com.backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920_수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N - 1;
            boolean flag = false;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (A[mid] > B[i]) {
                    end = mid - 1;
                } else if (A[mid] < B[i]) {
                    start = mid + 1;
                } else {

                    System.out.println("start : " + start + ", end : " + end + ", B[i] : " + B[i]);
                    flag = true;
                    sb.append(1 + "\n");
                    break;
                }
            }

            if (!flag) {
                sb.append(0 + "\n");
            }
        }

        System.out.println(sb);

    }
}
