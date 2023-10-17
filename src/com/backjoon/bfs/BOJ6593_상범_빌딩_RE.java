package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ6593_상범_빌딩_RE {

    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int L;
    static int R;
    static int C;
    static String[][][] map;
    static int[][][] building;
    static boolean[][][] visited;
    static Move start;
    static Move end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                System.out.println(sb);
                break;
            }

            map = new String[L][R][C];
            building = new int[L][R][C];
            visited = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                if (i > 0) br.readLine();
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = line.substring(k, k + 1);
                        if (map[i][j][k].equals("S")) {
                            start = new Move(k, j, i);
                        } else if (map[i][j][k].equals("E")) {
                            end = new Move(k, j, i);
                        }
                    }
                }
            }
            br.readLine();

            bfs();
        }
    }

    static void bfs() {
        Queue<Move> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Move poll = queue.poll();

            if (poll.x == end.x && poll.y == end.y && poll.z == end.z) {
//                System.out.println("Escaped in " + building[poll.z][poll.y][poll.x] + " minute(s).");
                sb.append("Escaped in ").append(building[poll.z][poll.y][poll.x]).append(" minute(s).\n");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];
                int Z = poll.z + dz[i];

                if (Z >= 0 && Z < L && Y >= 0 && Y < R && X >= 0 && X < C && !visited[Z][Y][X] && !map[Z][Y][X].equals("#")) {
                    building[Z][Y][X] = building[poll.z][poll.y][poll.x] + 1;
                    queue.add(new Move(X, Y, Z));
                    visited[Z][Y][X] = true;
                }
            }


        }

//        System.out.println("Trapped!\n");
        sb.append("Trapped!\n");
    }

    static class Move {
        public int x;
        public int y;
        public int z;

        public Move(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }


}
