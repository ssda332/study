package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[101][101];

        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            for (int i = H; i < H + 10; i++) {
                for (int j = W; j < W + 10; j++) {
                    paper[i][j] = true;
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (paper[i][j]) answer++;
            }
        }

        System.out.println(answer);
    }
}
