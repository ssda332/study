package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ18869_멀티버스_2 {

    static int M;
    static int N;
    static int[][] space;
    static int[] C;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 우주의 개수
        N = Integer.parseInt(st.nextToken()); // 각 우주에 있는 행성의 개수
        space = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            C = Arrays.stream(space[i].clone()).distinct().sorted().toArray();

            for (int j = 0; j < N; j++) {
                int answer = binarySearch(space[i][j]);
                space[i][j] = answer;
            }
        }

        for (int i = 0; i < M - 1; i++) {
            int[] A = space[i];

            for (int j = i + 1; j < M; j++) {
                int[] B = space[j];
                boolean flag = true;

                for (int k = 0; k < N; k++) {
                    if (A[k] != B[k]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) count++;
            }
        }

        System.out.println(count);
    }

    static int binarySearch(int target) {
        int lo = 0;
        int hi = C.length - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (target < C[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        if (target == C[lo]) return lo;
        return hi;
    }
}
