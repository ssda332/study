package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470_두_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int[] ans = new int[2];

        int left = 0;
        int right = N - 1;
        int start = A[left];
        int end = A[right];
        int max = start + end;

        while (left < right) {
//            System.out.println("left : " + left + ", right : " + right);

            if (Math.abs(max) > Math.abs((A[left] + A[right]))) {
                start = A[left];
                end = A[right];
                max = start + end;
            }

            if (A[left] + A[right] > 0) {
                right--;
            } else {
                left++;
            }

        }

        System.out.print(start + " ");
        System.out.println(end);
    }
}
