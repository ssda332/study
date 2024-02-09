package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ7453_합이_0인_네_정수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum1 = new int[N * N];
        int[] sum2 = new int[N * N];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum1[cnt] = A[i] + B[j];
                sum2[cnt] = C[i] + D[j];
                cnt++;
            }
        }

        Arrays.sort(sum2);

        int answer = 0;

        for (int i = 0; i < sum1.length; i++) {
            int target = sum1[i];
            int count = upper_bound(target, sum2) - lower_bound(target, sum2);
            answer += count;
        }

        System.out.println(answer);

    }

    static int lower_bound(int target, int[] sum2) {
        int lo = -1;
        int hi = sum2.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (target + sum2[mid] >= 0) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }

    static int upper_bound(int target, int[] sum2) {
        int lo = -1;
        int hi = sum2.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (target + sum2[mid] > 0) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }

}
