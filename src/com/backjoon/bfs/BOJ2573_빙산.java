package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ2573_빙산 {

    static int N;
    static int M;
    static int[][] iceberg;
    static int[][] nextYear;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int year = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        iceberg = new int[N][M];
        nextYear = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int answer = bfs();

            if (answer == 0) {
                System.out.println(0);
                return;
            } else if (answer > 1) {
                System.out.println(year);
                return;
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        iceberg[i][j] = nextYear[i][j];
                    }
                }
                visited = new boolean[N][M];
                nextYear = new int[N][M];

                year++;
            }

        }

    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] > 0 && !visited[i][j]) {
                    cnt++;
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[1];
                        int y = poll[0];
                        int size = iceberg[y][x];

                        for (int k = 0; k < 4; k++) {
                            int X = x + dx[k];
                            int Y = y + dy[k];

                            if (X >= 0 && X < M && Y >= 0 && Y < N) {
                                if (iceberg[Y][X] == 0) {
                                    size--;
                                }

                                if (!visited[Y][X] && iceberg[Y][X] > 0) {
                                    queue.add(new int[] {Y, X});
                                    visited[Y][X] = true;
                                }
                            }
                        }

                        if (size >= 0) nextYear[y][x] = size;

                    }
                }
            }
        }

        return cnt;
    }
}
