package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ6593_상범_빌딩 {

    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int L;
    static int R;
    static int C;
    static String[][][] building;
    static boolean[][][] visited;
    static int[] start;

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

            building = new String[L][R][C];
            visited = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                if (i > 0) br.readLine();
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = line.substring(k, k + 1);
                        if (building[i][j][k].equals("S")) {
                            start = new int[] {i, j, k, 0};
                            visited[i][j][k] = true;
                        }
                    }
                }
            }
            br.readLine();

            bfs();
        }


    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int z = poll[0];
            int y = poll[1];
            int x = poll[2];
            int minute = poll[3];

            if (building[z][y][x].equals("E")) {
                sb.append("Escaped in ").append(minute).append(" minute(s).\n");
//                sb.append("Escaped in " + minute +" minute(s).\n");
                return;
            }

            for (int i = 0; i < 5; i++) {
                int Z = z + dz[i];
                int Y = y + dy[i];
                int X = x + dx[i];

                if (Z >= 0 && Z < L && Y >= 0 && Y < R && X >= 0 && X < C && !visited[Z][Y][X] && !building[Z][Y][X].equals("#")) {
                    queue.add(new int[] {Z, Y, X, minute + 1});
                    visited[Z][Y][X] = true;
                }
            }
        }

        sb.append("Trapped!\n");
    }
}
