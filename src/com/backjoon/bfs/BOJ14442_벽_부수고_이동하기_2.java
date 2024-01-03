package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ14442_벽_부수고_이동하기_2 {

    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[K + 1][N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        bfs();


        if (N == 1 && M == 1) {
//            System.out.println(1);
            bw.write(1 + "\n");
        } else {
//            System.out.println(result);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();

    }

    static void bfs() {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Move poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X == M - 1 && Y == N - 1) {
                    result = poll.depth + 1;
                    return;
                }

                if (X < 0 || X >= M || Y < 0 || Y >= N || visited[poll.breakCnt][Y][X]) continue;
//                if (map[Y][X] == 1 && poll.breakCnt == K) continue;

                if (map[Y][X] == 0) {
                    queue.add(new Move(X, Y, poll.depth + 1, poll.breakCnt));
                    visited[poll.breakCnt][Y][X] = true;
                } else {

                    if (poll.breakCnt < K) { // 이동해야할 칸이 1이고 부술횟수가 아직 남아있을때
                        queue.add(new Move(X, Y, poll.depth + 1, poll.breakCnt + 1));
                        visited[poll.breakCnt][Y][X] = true;
                    }

                }

/*                if (map[Y][X] == 1) {
                    queue.add(new Move(X, Y, poll.depth + 1, poll.breakCnt + 1));
                    visited[Y][X][poll.breakCnt + 1] = true;
                } else {
                    queue.add(new Move(X, Y, poll.depth + 1, poll.breakCnt));
                    visited[Y][X][poll.breakCnt] = true;
                }*/

            }
        }

    }

    static class Move {
        public int x;
        public int y;
        public int depth;
        public int breakCnt;

        public Move(int x, int y, int depth, int breakCnt) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.breakCnt = breakCnt;
        }
    }
}
