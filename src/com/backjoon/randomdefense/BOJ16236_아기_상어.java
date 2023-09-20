package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ16236_아기_상어 {

    static int N;
    static int[][] A;
//    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
//        visited = new boolean[N][N];
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 9) {
                    startX = j;
                    startY = i;
                    A[i][j] = 0;
                }
            }
        }

        bfs(startX, startY, 2, 0);
    }

    static void bfs(int x, int y, int size, int depth) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[3] - o2[3] == 0) {
                    return o1[3] - o2[3];
                }

                if (o1[1] - o2[1] == 0) {
                    return o1[1] - o2[1];
                }

                return o1[0] - o2[0];
            }
        });
        queue.add(new int[]{x, y, size, depth});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int curX = poll[0];
            int curY = poll[1];
            int sharkSize = poll[2];
            int time = poll[3];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX > 0 && nextX < N && nextY > 0 && nextY < N) {
                    if (A[nextY][nextX] != 0) {

                    }
                }
            }
        }
    }
}

