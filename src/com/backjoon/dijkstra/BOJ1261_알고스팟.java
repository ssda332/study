package com.backjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ1261_알고스팟 {

    static int N;
    static int M;
    static int[][] map;
    static int[][] D;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.count, o.count);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        D = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
                D[i][j] = Integer.MAX_VALUE;
            }
        }

        int answer = dijkstra();
        System.out.println(answer);

    }

    static int dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 0));
        visited[0][0] = true;
        D[0][0] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X < 0 || X >= M || Y < 0 || Y >= N) continue;
                if (visited[Y][X]) continue;
                visited[Y][X] = true;


                if (map[Y][X] == 0) {
                    D[Y][X] = D[poll.y][poll.x];
                    queue.add(new Node(X, Y, poll.count));
                } else {
                    if (D[Y][X] > D[poll.y][poll.x] + 1) {
                        D[Y][X] = D[poll.y][poll.x] + 1;
                        queue.add(new Node(X, Y, D[Y][X]));
                    }
                }
            }
        }

        return D[N - 1][M - 1];
    }
}
