package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ16920_확장_게임 {

    static int N;
    static int M;
    static int P;
    static int[][] map;
    static int[] players;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] results;
    static Queue<Castle>[] queues = new LinkedList[10];
    static Queue<Castle> eQueue;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
//        PriorityQueue<Castle> queue = new PriorityQueue<>();

        map = new int[N][M];
        players = new int[P + 1];
        results = new int[P + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= P; i++) {
            players[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= 9; i++) {
            queues[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {

            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                String p = line.substring(j, j + 1);
                if (!p.equals(".")) {
                    if (p.equals("#")) {
                        map[i][j] = -1;
                    } else {
                        map[i][j] = Integer.parseInt(p);
//                        queue.add(new Castle(j, i, 1, map[i][j]));
                        queues[map[i][j]].add(new Castle(j, i, 1));
                        results[map[i][j]]++;
                    }
                }
            }
        }

        bfs();

        for (int i = 1; i <= P; i++) {
            System.out.print(results[i] + " ");
        }
    }

    static void bfs() {
        eQueue = new LinkedList<>();

        while (!queues[1].isEmpty() || !queues[2].isEmpty() || !queues[3].isEmpty() || !queues[4].isEmpty() || !queues[5].isEmpty() || !queues[6].isEmpty() || !queues[7].isEmpty() || !queues[8].isEmpty() || !queues[9].isEmpty()) {
            for (int i = 1; i <= 9; i++) {
                int size = queues[i].size();
                for (int j = 0; j < size; j++) {
                    expend(i, true);
                }

                while (!eQueue.isEmpty()) {
                    expend(i, false);
                }
            }
        }

    }

    private static void expend(int i, boolean flag) {
        Castle poll;
        if (flag) poll = queues[i].poll();
        else poll = eQueue.poll();

        for (int j = 0; j < 4; j++) {
            int X = poll.x + dx[j];
            int Y = poll.y + dy[j];

            if (X < 0 || X >= M || Y < 0 || Y >= N) {
                continue;
            }

            if (map[Y][X] == 0) {
                if (poll.depth < players[i]) {
                    // 확장
                    eQueue.add(new Castle(X, Y, poll.depth + 1));
                } else if (poll.depth == players[i]){
                    // 마지막 확장
                    queues[i].add(new Castle(X, Y, 1));
//                    flag = true;
                }

                map[Y][X] = i;
                results[i]++;
            }

        }
    }

    static class Castle {
        public int x;
        public int y;
        public int depth;

        public Castle(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

    }
}
