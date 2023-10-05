package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ2468_안전_영역 {

    static int N;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i <= 100; i++) {
            max = Math.max(max, bfs(i));
            visited = new boolean[N][N];
        }

        System.out.println(max);

    }

    static int bfs(int depth) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && A[i][j] > depth) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int X = poll[1] + dx[k];
                            int Y = poll[0] + dy[k];

                            if (X >= 0 && X < N && Y >= 0 && Y < N) {
                                if (!visited[Y][X] && A[Y][X] > depth) {
                                    queue.add(new int[] {Y, X});
                                    visited[Y][X] = true;
                                }
                            }
                        }
                    }

                    count++;
                }

            }
        }

        return count;
    }
}
