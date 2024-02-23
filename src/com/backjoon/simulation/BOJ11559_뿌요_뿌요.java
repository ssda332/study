package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ11559_뿌요_뿌요 {

    static char[][] map;
    static boolean[][] visited;
    static class Puyo {
        int x;
        int y;

        public Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;
    static boolean isChained;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();

            for (int j = 0; j < 6; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        // 1. 뿌요할수있는지 전체탐색
        // 2. 뿌요하기
        // 3. 뿌요된칸 아래로 채우기
        // 4. 반복

        boolean flag = true;
        while (flag) {
            flag = search();
            if (flag) answer++;
        };

        System.out.println(answer);
    }

    static boolean search() {
        visited = new boolean[12][6];
        isChained = false;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visited[i][j] || map[i][j] == '.') continue;
                bfs(j, i);

            }
        }

        if (isChained) {
            dropPuyo();
            return true;
        } else {
            return false;
        }

    }

    static void dropPuyo() {
        for (int x = 0; x < 6; x++) {
            for (int y = 11; y >= 0; y--) {
                while (map[y][x] == 'x') {
                    for (int i = y; i > 0; i--) {
                        map[i][x] = map[i - 1][x];
                    }

                    map[0][x] = '.';
                }
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Puyo> queue = new LinkedList<>();
        Queue<Puyo> removeQueue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new Puyo(x, y));
        removeQueue.add(new Puyo(x, y));

        while (!queue.isEmpty()) {
            Puyo poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X < 0 || X >= 6 || Y < 0 || Y >= 12) continue;
                if (visited[Y][X]) continue;
                if (map[y][x] != map[Y][X]) continue;

                queue.add(new Puyo(X, Y));
                removeQueue.add(new Puyo(X, Y));
                visited[Y][X] = true;
            }
        }

        if (removeQueue.size() >= 4) {
            while (!removeQueue.isEmpty()) {
                Puyo poll = removeQueue.poll();
                map[poll.y][poll.x] = 'x';
                isChained = true;
            }
        }

    }
}

