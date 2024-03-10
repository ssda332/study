package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ15903_카드_합체_놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        // 1 3 2 5 7
        // 2 4 4 5 7
        // 4 5 6 6 7  2 4 7 9 9
        // 6 6 7 9 9

        //
        while (m > 0) {
            Arrays.sort(A);
            long sum = A[0] + A[1];
            A[0] = sum; A[1] = sum;
            m--;
        }

        long answer = Arrays.stream(A).sum();
        System.out.println(answer);
    }
}
