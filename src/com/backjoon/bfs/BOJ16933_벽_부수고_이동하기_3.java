package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ16933_벽_부수고_이동하기_3 {

    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][][][] visited;
    static int[] dx = {1, 0, -1, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[2][K + 1][N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        bfs();

        if (N == 1 && M == 1) {
            System.out.println(1);
        } else {
            System.out.println(result);
        }

    }

    static void bfs() {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(0, 0, 1, 0, 0));
        visited[0][0][0][0] = true;

        while (!queue.isEmpty()) {
            Move poll = queue.poll();

            for (int i = 0; i < 5; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X == M - 1 && Y == N - 1) {
                    result = poll.depth + 1;
                    return;
                }

                if (X < 0 || X >= M || Y < 0 || Y >= N || visited[1 - poll.day][poll.breakCnt][Y][X]) continue;

                if (map[Y][X] == 0) {
                    queue.add(new Move(X, Y, poll.depth + 1, poll.breakCnt, 1 - poll.day));
                    visited[1 - poll.day][poll.breakCnt][Y][X] = true;
                } else {
                    if (poll.breakCnt < K && poll.day == 0) {
                        queue.add(new Move(X, Y, poll.depth + 1, poll.breakCnt + 1, 1 - poll.day));
                        visited[1 - poll.day][poll.breakCnt + 1][Y][X] = true;
                    } else if (poll.breakCnt < K && X == poll.x && Y == poll.y) {
                        queue.add(new Move(X, Y, poll.depth + 1, poll.breakCnt, 1 - poll.day));
                        visited[1 - poll.day][poll.breakCnt][Y][X] = true;
                    }
                }
            }
        }
    }

    static class Move {
        public int x;
        public int y;
        public int depth;
        public int breakCnt;
        public int day;

        public Move(int x, int y, int depth, int breakCnt, int day) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.breakCnt = breakCnt;
            this.day = day;
        }
    }
}
