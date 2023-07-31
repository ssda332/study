package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178_미로_탐색 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] maze;
    static int N;
    static int M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(maze[N-1][M-1]);
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (!visited[x][y] && maze[x][y] == 1) {
                        maze[x][y] = maze[now[0]][now[1]] + 1;
                        visited[x][y] = true;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }

}

