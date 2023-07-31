package com.backjoon.dp;

import java.io.*;

public class BOJ9095_123_더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 1) bw.write(1 + "\n");
            if (N == 2) bw.write(2 + "\n");
            if (N == 3) bw.write(4 + "\n");

            if (N >= 4) {
                int[] A = new int[N + 1];

                A[1] = 1;
                A[2] = 2;
                A[3] = 4;

                for (int j = 4; j <= N; j++) {
                    A[j] = A[j -1] + A[j - 2] + A[j -3];
                }
                bw.write(A[N] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
