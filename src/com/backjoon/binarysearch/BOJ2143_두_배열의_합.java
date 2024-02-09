package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2143_두_배열의_합 {

    static int[] A;
    static int[] B;
    static int T;
    static long answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        A = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        A[1] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n; i++) {
            A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        B = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        B[1] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= m; i++) {
            B[i] = B[i - 1] + Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                list1.add(A[j] - A[i]);
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = i + 1; j <= m; j++) {
                list2.add(B[j] - B[i]);
            }
        }

        Collections.sort(list2);
        A = list1.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        B = list2.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < A.length; i++) {
            int count = upper_bound(i) - lower_bound(i);
            answer += count;
        }

        System.out.println(answer);
    }

    static int upper_bound(int i) {
        int lo = -1;
        int hi = B.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (A[i] + B[mid] > T) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }

    static int lower_bound(int i) {
        int lo = -1;
        int hi = B.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (A[i] + B[mid] >= T) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }
}
