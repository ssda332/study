package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ7569_토마토 {

    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        // O(100^3 + 100^3 * 6) = O(7 * 100^3) ≒ O(100^3)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] box = new int[H][N][M];
        boolean flag = false;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 0) {
                        flag = true;
                    } else if (box[i][j][k] == 1) {
                        queue.add(new int[] {i, j, k});
                    }
                }
            }
        }

        if (!flag) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int z = poll[0];
            int y = poll[1];
            int x = poll[2];

            for (int i = 0; i < 6; i++) {
                int Z = z + dz[i];
                int Y = y + dy[i];
                int X = x + dx[i];

                if (X >= 0 && X < M && Y >= 0 && Y < N && Z >= 0 && Z < H && box[Z][Y][X] == 0) {
                    queue.add(new int[] {Z, Y, X});
                    box[Z][Y][X] = box[z][y][x] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    } else if (box[i][j][k] > max) {
                        max = box[i][j][k];
                    }
                }
            }
        }
        System.out.println(max - 1);

    }
}
