package com.backjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ2665_미로_만들기 {

    static int N;
    static char[][] map;
    static int[][] D;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int broke;

        public Node(int x, int y, int broke) {
            this.x = x;
            this.y = y;
            this.broke = broke;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.broke, o.broke);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        D = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                D[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra();

        System.out.println(D[N - 1][N - 1]);

    }

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 0));
        D[0][0] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X < 0 || X >= N || Y < 0 || Y >= N) continue;

                if (map[Y][X] == '1') {
                    if (D[Y][X] > D[poll.y][poll.x]) {
                        D[Y][X] = D[poll.y][poll.x];
                        queue.add(new Node(X, Y, poll.broke));
                    }
                } else {
                    if (D[Y][X] > D[poll.y][poll.x] + 1) {
                        D[Y][X] = D[poll.y][poll.x] + 1;
                        queue.add(new Node(X, Y, poll.broke + 1));
                    }
                }
            }
        }
    }
}
