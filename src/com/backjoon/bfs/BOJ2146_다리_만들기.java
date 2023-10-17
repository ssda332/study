package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ2146_다리_만들기 {

    static int N;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int min = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int landNum = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] >= 1 && !visited[i][j]) {
                    landCount(j, i, landNum);
                    landNum++;
                }
            }
        }
/*

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
*/

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] >= 1 && !visited[i][j]) {
                    visited = new boolean[N][N];
                    bfsX(j, i, A[i][j]);
                }
            }
        }

        System.out.println(min);
    }

    static void landCount(int x, int y, int landNum) {
        Queue<Land> queue = new LinkedList<>();
        A[y][x] = landNum;
        queue.add(new Land(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Land poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X >= 0 && X < N && Y >= 0 && Y < N && !visited[Y][X]) {
                    if (A[Y][X] == 1) {
                        queue.add(new Land(X, Y));
                        visited[Y][X] = true;
                        A[Y][X] = landNum;
                    }
                }
            }
        }
    }


    static void bfsX(int x, int y, int landNum) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(x, y, 0));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Move poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X < 0 || X >= N || Y < 0 || Y >= N) continue;
                if (visited[Y][X]) continue;
                if (A[Y][X] == landNum) continue;
                if (A[Y][X] != landNum && A[Y][X] > 0) {
                    min = Math.min(min, poll.length);
                    return;
                }

                queue.add(new Move(X, Y, poll.length + 1));
                visited[Y][X] = true;
            }
        }
    }

    static class Move {
        public int x;
        public int y;
        public int length;

        public Move(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    static class Land {
        public int x;
        public int y;

        public Land(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
