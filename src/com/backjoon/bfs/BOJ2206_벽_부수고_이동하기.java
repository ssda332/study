package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ2206_벽_부수고_이동하기 {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(0, 0, 1, false));
        visited[0][0][0] = true;

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        while (!queue.isEmpty()) {
            Move curMove = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = curMove.x + dx[i];
                int Y = curMove.y + dy[i];

                if (X >= 0 && X < M && Y >= 0 && Y < N) {
                    if (X == M - 1 && Y == N - 1) {
                        System.out.println(curMove.depth + 1);
                        return;
                    }

                    if (map[Y][X] == 1) {
                        if (!curMove.isBreak) {
                            queue.add(new Move(X, Y, curMove.depth + 1, true));
                            visited[Y][X][1] = true;
                        }
                    } else {
                        if (!visited[Y][X][0] && !curMove.isBreak) {
                            queue.add(new Move(X, Y, curMove.depth + 1, false));
                            visited[Y][X][0] = true;
                        } else if (!visited[Y][X][1] && curMove.isBreak) {
                            queue.add(new Move(X, Y, curMove.depth + 1, true));
                            visited[Y][X][1] = true;
                        }

                    }

                }
            }
        }

        System.out.println(-1);
    }

    static class Move {
        public int x;
        public int y;
        public int depth;
        public boolean isBreak;

        public Move(int x, int y, int depth, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.isBreak = isBreak;
        }
    }
}
