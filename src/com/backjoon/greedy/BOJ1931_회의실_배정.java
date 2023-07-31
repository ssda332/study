package com.backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931_회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[i][0] = s;
            A[i][1] = e;
        }

        Arrays.sort(A, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int start = 0;
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (start <= A[i][0]) {
                cnt++;
                start = A[i][1];
            }
        }

        System.out.println(cnt);

    }
}
