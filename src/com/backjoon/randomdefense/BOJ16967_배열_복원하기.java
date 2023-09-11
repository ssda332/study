package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ16967_배열_복원하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] A = new int[H][W];
        int[][] B = new int[H + X][W + Y];

        for (int i = 0; i < B.length; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < B[0].length; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
                if (B[i][j] == 0) {
                    continue;
                }

                if (i < H && j < W) {
                    if (i < X || j < Y) {
                        A[i][j] = B[i][j];
                    } else {
                        A[i][j] = B[i][j] - A[i - X][j - Y];
                    }
                }
            }
        }

        Arrays.stream(A)
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);


    }
}
