package com.backjoon.twopointer;

import java.io.*;
import java.util.*;

public class BOJ2230_수_고르기_RE {
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
        int answer = Integer.MAX_VALUE;

        for (int s = 0; s < N; s++) {
            int e = s;
            while (e < N && A[e] - A[s] < M) e++;
            if (e == N) break;
            answer = Math.min(answer, A[e] - A[s]);
        }

        System.out.println(answer);
    }
}
