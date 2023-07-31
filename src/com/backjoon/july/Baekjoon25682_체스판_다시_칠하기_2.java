package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon25682_체스판_다시_칠하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] black = new int[N+1][M+1];
        int[][] white = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= M; j++) {
                int blackTemp = 0;
                int whiteTemp = 0;

                if ((i + j) % 2 == 0 && line.charAt(j - 1) == 'B') {
                    blackTemp = 1;
                }

                if ((i + j) % 2 == 0 && line.charAt(j - 1) == 'W') {
                    whiteTemp = 1;
                }

                if ((i + j) % 2 == 1 && line.charAt(j - 1) == 'B') {
                    whiteTemp = 1;
                }

                if ((i + j) % 2 == 1 && line.charAt(j - 1) == 'W') {
                    blackTemp = 1;
                }

                black[i][j] = black[i - 1][j] + black[i][j - 1] - black[i - 1][j - 1] + blackTemp;
                white[i][j] = white[i - 1][j] + white[i][j - 1] - white[i - 1][j - 1] + whiteTemp;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = K; i < N + 1; i++) {
            for (int j = K; j < M + 1; j++) {
                int blackSum = black[i][j] - black[i - K][j] - black[i][j - K] + black[i - K][j - K];
                int whiteSum = white[i][j] - white[i - K][j] - white[i][j - K] + white[i - K][j - K];

                min = Math.min(min, Math.min(blackSum, whiteSum));
            }
        }

        System.out.println(min);
    }
}
