package com.backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230_수_고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
        // 차이가 M 이상이고 제일 작은 경우

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while (start < N - 1 && end < N) {
            int gap = A[end] - A[start];

            if (gap >= M) {
                if (min >= gap) {
                    min = gap;
                    start++;
                }else {
                    start++;
                }

//                System.out.println("start : " + start + " end : " + end);
            } else {
                end++;
//                System.out.println("start : " + start + " end : " + end);
            }
        }

        System.out.println(min);


    }
}
