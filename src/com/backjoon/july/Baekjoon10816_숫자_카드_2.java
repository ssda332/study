package com.backjoon.july;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10816_숫자_카드_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            bw.write((upperBound(A, target) - lowerBound(A, target) + 1) + " ");

        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static int upperBound(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    public static int lowerBound(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

}
