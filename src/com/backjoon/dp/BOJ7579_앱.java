package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ7579_앱 {

    static class App {
        int bytes;
        int cost;

        public App(int bytes, int cost) {
            this.bytes = bytes;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        App[] apps = new App[N + 1];

        for (int i = 1; i <= N; i++) {
            apps[i] = new App(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));
        }

        int[][] DP = new int[N + 1][10001];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (j - apps[i].cost < 0) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - apps[i].cost] + apps[i].bytes);
                }

                if (DP[i][j] >= M && i == N) {
                    System.out.println(j);
                    return;
                }
            }
        }

    }
}
