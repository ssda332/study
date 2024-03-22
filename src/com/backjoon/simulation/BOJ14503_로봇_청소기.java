package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ14503_로봇_청소기 {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static class Cleaner {
        int x;
        int y;
        int dir;

        public Cleaner(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        void move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void rotate() {
            this.dir = (7 + this.dir) % 4;
        }
    }

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = getInteger(st);
        M = getInteger(st);
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        Cleaner c = new Cleaner(getInteger(st), getInteger(st), getInteger(st));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = getInteger(st);
            }
        }

        cleaning(c);

        System.out.println(answer);

    }

    static void cleaning(Cleaner c) {

        boolean isWork = true;
        while (isWork) {
            if (map[c.x][c.y] == 0) {
                answer++;
                map[c.x][c.y] = 2;
            }

            isWork = search(c);
        }
    }

    static boolean search(Cleaner c) {
        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            int X = c.x + dx[i];
            int Y = c.y + dy[i];

            if (!areaCheckWall(X, Y)) continue;
            if (areaCheck(X, Y)) flag = true;
        }

        int X = c.x;
        int Y = c.y;

        if (flag) {
            c.rotate();

            if (c.dir == 0) {
                X--;
            } else if (c.dir == 1) {
                Y++;
            } else if (c.dir == 2) {
                X++;
            } else {
                Y--;
            }

            if (areaCheck(X, Y) && areaCheckWall(X, Y)) {
                c.move(X, Y);
            }

            return true;

        } else {
            if (c.dir == 0) {
                X++;
            } else if (c.dir == 1) {
                Y--;
            } else if (c.dir == 2) {
                X--;
            } else {
                Y++;
            }

            if (areaCheckWall(X, Y)) {
                c.move(X, Y);
                return true;
            } else {
                return false;
            }
        }
    }

    // 청소되지 않은 빈칸 확인
    static boolean areaCheck(int x, int y) {
        if (map[x][y] == 2) return false;
        return true;
    }

    static boolean areaCheckWall(int x, int y) {
        if (map[x][y] == 1) return false;
        return true;
    }

    static int getInteger(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
