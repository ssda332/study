package com.backjoon.string;

import java.io.*;

public class BOJ2999_비밀_이메일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        char[][] A = new char[1][N];
        for (int i = N; i >= 1; i--) {
            if (N % i == 0 && i <= N / i) {
                A = new char[N / i][i];
                break;
            }
        }

        int R = A.length;
        int C = A[0].length;

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = str.charAt(cnt);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                sb.append(A[j][i]);
            }
        }

        System.out.println(sb);
    }
}
