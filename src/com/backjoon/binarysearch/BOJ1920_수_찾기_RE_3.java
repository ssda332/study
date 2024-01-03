package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1920_수_찾기_RE_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());

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
                if (A[mid] > B[i]) end = mid - 1;
                else if (A[mid] < B[i]) start = mid + 1;
                else {
                    flag = true;
                    end = mid - 1;
                }
            }

            if (flag) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);






    }
}
