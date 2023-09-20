package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ7576_토마토 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();

        boolean isNotRipe = false;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                } else if (box[i][j] == 0) {
                    isNotRipe = true;
                } else {
                    visited[i][j] = true;
                }
            }
        }

        if (!isNotRipe) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];
            int time = poll[2];

            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if (X >= 0 && X < M && Y >= 0 && Y < N && !visited[Y][X] && box[Y][X] == 0) {
                    queue.add(new int[] {Y, X, time + 1});
                    box[Y][X] = time + 1;
                    visited[Y][X] = true;
                }
            }

        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                if (box[i][j] > max) {
                    max = box[i][j];
                }
            }
        }

        System.out.println(max);


    }

}
