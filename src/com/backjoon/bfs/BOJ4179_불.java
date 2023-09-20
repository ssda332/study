package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ4179_불 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] maze = new String[R][C];
//        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();
//        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = line.substring(j, j + 1);

                if (maze[i][j].equals("J")) {
                    queue.add(new Node(1, j, i, 0));
//                    visited[i][j] = true;
                } else if (maze[i][j].equals("F")) {
                    queue.add(new Node(2, j, i, 0));
//                    visited[i][j] = true;
                } else if (maze[i][j].equals("#")) {
//                    visited[i][j] = true;
                }

            }
        }


        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X >= 0 && X < C && Y >= 0 && Y < R) {
                    if (maze[Y][X].equals(".")) {
                        if (poll.type == 1) {
                            queue.add(new Node(1, X, Y, poll.time + 1));
                            maze[Y][X] = "J";

//                            visited[Y][X] = true;
                        } else if (poll.type == 2) {
                            /*if (X == currentX && Y == currentY) {
                                System.out.println("IMPOSSIBLE");
                                return;
                            }*/
                            queue.add(new Node(2, X, Y, poll.time + 1));
//                            visited[Y][X] = true;
                            maze[Y][X] = "F";
                        }
                    }
                } else if ((X < 0 || X >= C || Y < 0 || Y >= R) && poll.type == 1) {
                    System.out.println(poll.time + 1);
                    return;
                }
            }
        }

        System.out.println("IMPOSSIBLE");

    }

    static class Node implements Comparable<Node>{
        public int type;
        public int x;
        public int y;
        public int time;

        public Node(int type, int x, int y, int time) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o1) {
            return this.type - o1.type;
        }
    }
}
