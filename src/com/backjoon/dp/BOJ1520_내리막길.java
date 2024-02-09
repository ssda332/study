package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ1520_내리막길 {

    static int N;
    static int M;
    static int[][] map;
    static int[][] DP;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        DP = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j] = -1;
            }
        }

        int answer = dfs(0, 0);
        System.out.println(answer);
    }

    static int dfs(int x, int y) {
        if (y == N - 1 && x == M - 1) return DP[y][x] = 1;
        if (DP[y][x] > -1) return DP[y][x];
        DP[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X < 0 || X >= M || Y < 0 || Y >= N) continue;
            if (map[y][x] <= map[Y][X]) continue;

            if (DP[Y][X] > 0) {
                DP[y][x] += DP[Y][X];
                continue;
            }
            DP[y][x] += dfs(X, Y);
        }

        return DP[y][x];
    }

}
