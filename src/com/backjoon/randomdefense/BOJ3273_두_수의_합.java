package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ3273_두_수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());
        Arrays.sort(A);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int lo = -1;
            int hi = N - 1;

            while (lo + 1 < hi) {
                int mid = (lo + hi) / 2;

                if (A[mid] + A[i] >= target) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }

            if (A[hi] + A[i] == target) answer++;
        }

        System.out.println(answer / 2);


    }
}
