package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ2583_영역_구하기 {

    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int M;
    static int N;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    visited[j][k] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    int count = bfs(j, i);
//                    sb.append(count).append(" ");
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());
        result.stream().sorted().forEach(i -> {
            sb.append(i).append(" ");
        });
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll[0] + dx[i];
                int Y = poll[1] + dy[i];

                if (X >= 0 && X < M && Y >= 0 && Y < N && !visited[Y][X]) {
                    queue.add(new int[]{X, Y});
                    visited[Y][X] = true;
                    count++;
                }

            }
        }

        return count;
    }
}
