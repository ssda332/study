package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ4179_불_RE {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] maze = new String[R][C];
        Queue<Node> queueJ = new LinkedList<>();
        Queue<Node> queueF = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = line.substring(j, j + 1);

                if (maze[i][j].equals("J")) {
                    queueJ.add(new Node(j, i, 0));
                } else if (maze[i][j].equals("F")){
                    queueF.add(new Node(j, i, 0));
                }
            }
        }

        while (!queueJ.isEmpty()) {

            int size = queueF.size();

            for (int i = 0; i < size; i++) {
                Node poll = queueF.poll();

                for (int j = 0; j < 4; j++) {
                    int X = poll.x + dx[j];
                    int Y = poll.y + dy[j];

                    if (X >= 0 && X < C && Y >= 0 && Y < R) {
                        if (maze[Y][X].equals(".") || maze[Y][X].equals("J")) {
                            queueF.add(new Node(X, Y, poll.time + 1));
                            maze[Y][X] = "F";
                        }
                    }
                }

            }

            size = queueJ.size();
            for (int i = 0; i < size; i++) {

                Node poll = queueJ.poll();

                for (int j = 0; j < 4; j++) {
                    int X = poll.x + dx[j];
                    int Y = poll.y + dy[j];

                    if (X >= 0 && X < C && Y >= 0 && Y < R && maze[Y][X].equals(".")) {
                        queueJ.add(new Node(X, Y, poll.time + 1));
                        maze[Y][X] = "J";
                    } else if (X < 0 || X >= C || Y < 0 || Y >= R) {
                        System.out.println(poll.time + 1);
                        return;
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");

    }

    static class Node {
        public int x;
        public int y;
        public int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }
}
