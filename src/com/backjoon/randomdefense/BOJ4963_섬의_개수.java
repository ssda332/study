package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ4963_섬의_개수 {

    static int w;
    static int h;
    static int[][] map;
    static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];

            if (w == 0 && h == 0) break;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(j, i);
                        cnt++;
                    }
                }
            }

            sb.append(cnt + "\n");

        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 8; i++) {
                int X = poll[0] + dx[i];
                int Y = poll[1] + dy[i];

                if (X >= 0 && X < w && Y >= 0 && Y < h && !visited[Y][X] && map[Y][X] == 1) {
                    visited[Y][X] = true;
                    queue.add(new int[] {X, Y});
                }
            }
        }
    }
}
