package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ14940_쉬운_최단거리 {

    static int n;
    static int m;
    static int[][] A;
    static int[][] B;
    static int[] target;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        //1002
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        B = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 2) {
                    target = new int[] {i, j};
                }
            }
        }

        bfs(target);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i][j] == 0 && A[i][j] == 1) {
                    System.out.print(-1 + " ");
                }else {
                    System.out.print(B[i][j] + " ");
                }

            }
            System.out.println();
        }

    }

    static void bfs(int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(target);
        visited[target[0]][target[1]] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];

            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if (X >= 0 && X < m && Y >= 0 && Y < n && A[Y][X] != 0 && !visited[Y][X]) {
                    queue.add(new int[] {Y, X});
                    visited[Y][X] = true;
                    B[Y][X] = B[y][x] + 1;
                }
            }
        }

    }
}
