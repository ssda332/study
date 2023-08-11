package com.backjoon.dp;

import java.io.*;

public class BOJ9095_123_더하기_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] D = new int[N + 1];
            D[1] = 1; D[2] = 2; D[3] = 4;
            for (int j = 4; j <= N; j++) {
                D[j] = D[j - 3] + D[j - 2] + D[j - 1];
            }

            bw.write(D[N] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
