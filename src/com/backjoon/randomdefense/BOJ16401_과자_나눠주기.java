package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ16401_과자_나눠주기 {

    static int M;
    static int N;
    static int[] A;
    static int cnt = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int max = Arrays.stream(A).max().getAsInt();

        binarySearch(1, max);

        System.out.println(result);

    }

    static void binarySearch(int left, int right) {
        while (left <= right) {
            cnt = 0;
            int mid = left + (right - left) / 2;

            for (int i = 0; i < N; i++) {
                cnt += A[i] / mid;
            }

            if (cnt >= M) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
    }
}
