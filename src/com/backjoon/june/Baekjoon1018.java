package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        String[] chessInput = new String[N];
        for (int i = 0; i < N; i++) {
            chessInput[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                min = Math.min(min, check(i, j, chessInput));
            }
        }

        System.out.println(min);

    }

    public static int check(int i, int j, String[] chessInput) {
        int resultBlack = 0;
        int resultWhite = 0;

        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if ((k % 2 == 0 && l % 2 == 0) || (k % 2 == 1 && l % 2 == 1)) {
                    if (chessInput[k].charAt(l) == 'B') {
                        resultWhite++;
                    }
                    if (chessInput[k].charAt(l) == 'W') {
                        resultBlack++;
                    }
                } else {
                    if (chessInput[k].charAt(l) == 'W') resultWhite++;
                    if (chessInput[k].charAt(l) == 'B') resultBlack++;
                }

            }
        }
        return Math.min(resultWhite, resultBlack);
    }
}
