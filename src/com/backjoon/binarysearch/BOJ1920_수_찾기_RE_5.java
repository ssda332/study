package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1920_수_찾기_RE_5 {

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

            int result = binarySearch(target);
            sb.append(result).append("\n");
        }

        System.out.println(sb);


    }

    static int binarySearch(int target) {
        int lo = -1;
        int hi = N - 1;

        while (lo + 1 < hi) {  // lo hi
            int mid = (lo + hi) / 2;

            if (A[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        if (A[hi] == target) return 1;
        return 0;
    }


}
