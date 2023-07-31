package com.backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012_유기농_배추 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] A;
    static boolean[][] visited;
    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            A = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                A[y][x] = 1;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (!visited[y][x] && A[y][x] == 1) {
                        cnt++;
                        BFS(x, y);
                    }
                }
            }

            sb.append(cnt + "\n");

        }
        System.out.println(sb);
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[] position = {x, y};

        queue.add(position);
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int X = poll[0] + dx[i];
                int Y = poll[1] + dy[i];
                if (X >= 0 && X < A[0].length && Y >= 0 && Y < A.length) {
                    if (A[Y][X] == 1 && !visited[Y][X]) {
//                        System.out.println("X : " + X + ", Y : " + Y);
                        visited[Y][X] = true;
                        int[] arr = {X, Y};
                        queue.add(arr);
                    }
                }
            }
        }

    }
}
