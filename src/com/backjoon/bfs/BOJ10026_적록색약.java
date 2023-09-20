package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ10026_적록색약 {

    static int N;
    static boolean[][] visited;
    static String[][] pic;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pic = new String[N][N];
        visited = new boolean[N][N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                pic[i][j] = line.substring(j, j + 1);
            }
        }

        sb.append(bfs()).append(" ");
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (pic[i][j].equals("G")) {
                    pic[i][j] = "R";
                }
            }
        }
        sb.append(bfs());

        System.out.println(sb);

    }

    static int bfs() {
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(pic[i][j], j, i));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Node poll = queue.poll();
                        int x = poll.x;
                        int y = poll.y;
                        String type = poll.type;

                        for (int k = 0; k < 4; k++) {
                            int X = x + dx[k];
                            int Y = y + dy[k];

                            if (X >= 0 && X < N && Y >= 0 && Y < N && !visited[Y][X] && pic[Y][X].equals(type)) {
                                queue.add(new Node(type, X, Y));
                                visited[Y][X] = true;
                            }
                        }
                    }

                    result++;
                }
            }
        }

        return result;
    }

    static class Node {
        public String type;
        public int x;
        public int y;

        public Node(String type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}
