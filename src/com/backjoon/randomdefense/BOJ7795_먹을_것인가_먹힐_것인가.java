package com.backjoon.randomdefense;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795_먹을_것인가_먹힐_것인가 {

    static int N;
    static int M;
    static int[] A;
    static int[] B;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);
            // A의 크기가 B보다 큰 쌍

            for (int j = 0; j < N; j++) {
                binarySearch(A[j]);
            }

            bw.write(answer + "\n");
            answer = 0;
        }

        bw.flush();
        bw.close();
    }
    static void binarySearch(int target) {
        int start = 0;
        int end = M - 1;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) / 2;
            if (target > B[middle]) {
                start = middle + 1;
            }else {
                end = middle - 1;
            }
        }

        answer += start;
    }
}
