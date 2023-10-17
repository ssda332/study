package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ1600_말이_되고픈_원숭이 {

    static int K;
    static int W;
    static int H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] dx_horse = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy_horse = {2, 1, -1, -2, -2, -1, 1, 2};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void bfs() {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Move poll = queue.poll();

            if (poll.x == W - 1 && poll.y == H - 1) {
//                min = Math.min(min, poll.depth);
                min = poll.depth;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X < 0 || X >= W || Y < 0 || Y >= H) continue;
                if (visited[Y][X][poll.usedHorse]) continue;
                if (map[Y][X] == 1) continue;

                queue.add(new Move(X, Y, poll.depth + 1, poll.usedHorse));
                visited[Y][X][poll.usedHorse] = true;
            }

            if (poll.usedHorse + 1 <= K) {
                for (int i = 0; i < 8; i++) {
                    int X = poll.x + dx_horse[i];
                    int Y = poll.y + dy_horse[i];

                    if (X < 0 || X >= W || Y < 0 || Y >= H) continue;
                    if (visited[Y][X][poll.usedHorse + 1]) continue;
                    if (map[Y][X] == 1) continue;

                    queue.add(new Move(X, Y, poll.depth + 1, poll.usedHorse + 1));
                    visited[Y][X][poll.usedHorse + 1] = true;
                }
            }
        }
    }

    static class Move {
        public int x;
        public int y;
        public int depth;
        public int usedHorse;

        public Move(int x, int y, int depth, int usedHorse) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.usedHorse = usedHorse;
        }
    }
}
