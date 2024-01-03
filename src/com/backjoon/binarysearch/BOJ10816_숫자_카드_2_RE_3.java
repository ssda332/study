package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ10816_숫자_카드_2_RE_3 {

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int result = upper_idx(target) - lower_idx(target);

            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    static int lower_idx(int target) {
        int start = 0;
        int end = N;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int upper_idx(int target) {
        int start = 0;
        int end = N;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
