package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ7562_나이트의_이동 {

    static StringBuilder sb;
    static int l;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] chess;

    public static void main(String[] args) throws IOException {
        // O(300^2 * 9) ≒ O(300^2)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentY = Integer.parseInt(st.nextToken());
            int currentX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetY = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken());

            if (currentY == targetY && currentX == targetX) {
                sb.append(0).append("\n");
                continue;
            }

            chess = new int[l][l];

            chess[currentY][currentX] = -1;
            chess[targetY][targetX] = -2;

            bfs(currentX, currentY);

        }

        System.out.println(sb);

    }

    static void bfs(int curX, int curY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, curX, curY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int depth = poll[0];
            int x = poll[1];
            int y = poll[2];

            for (int i = 0; i < 8; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if (X >= 0 && X < l && Y >= 0 && Y < l) {
                    if (chess[Y][X] == 0) {
                        queue.add(new int[] {depth + 1, X, Y});
                        chess[Y][X] = 1;
                    } else if (chess[Y][X] == -2) {
                        sb.append(depth + 1).append("\n");
                        return;
                    }
                }
            }
        }
    }

    static class Node {
        public int depth;
        public int x;
        public int y;

        public Node(int depth, int x, int y) {
            this.depth = depth;
            this.x = x;
            this.y = y;
        }
    }

}
