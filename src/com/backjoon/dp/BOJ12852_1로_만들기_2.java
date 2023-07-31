package com.backjoon.dp;

import java.io.*;

public class BOJ12852_1로_만들기_2 {

    static int[] D;
    static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        D = new int[N + 1];
        P = new int[N + 1];

        // D[i] = i를 1로 만드는 연산횟수의 최소값
        // D[i] = D[i - 1] + 1
        // D[i] = min(D[i / 2] + 1, D[i])
        // D[i] = min(D[i / 3] + 1, D[i])
        // P[n] = min(n - 1, n / 2, n / 3)

        D[1] = 0;

        for (int n = 2; n <= N; n++) {
            D[n] = D[n - 1] + 1;
            P[n] = n - 1;
            if (n % 2 == 0 && D[n] > D[n/2] + 1) {
                D[n] = Math.min(D[n], D[n / 2] + 1);
                P[n] = n / 2;
            }
            if (n % 3 == 0 && D[n] > D[n/3] + 1) {
                D[n] = Math.min(D[n], D[n / 3] + 1);
                P[n] = n / 3;
            }

        }

        bw.write(D[N] + "\n");
        int i = N;
        bw.write(N + " ");
        while (i > 1) {
            bw.write(P[i] + " ");
            i = P[i];
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
