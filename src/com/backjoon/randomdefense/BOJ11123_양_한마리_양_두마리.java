package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11123_양_한마리_양_두마리 {

    static String[][] A;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            A = new String[X][Y];
            visited = new boolean[X][Y];

            for (int x = 0; x < X; x++) {
                String line = br.readLine();
                for (int y = 0; y < Y; y++) {
                    A[x][y] = line.substring(y, y + 1);
                    if (A[x][y].equals(".")) visited[x][y] = true;
                }
            }

            int count = 0;

            for (int x = 0; x < X; x++) {
                for (int y = 0; y < Y; y++) {
                    if (!visited[x][y]) {
                        count++;
                        bfs(x, y);
                    }
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        int[] coor = {x, y};
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(coor);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll[0] + dx[i];
                int Y = poll[1] + dy[i];
                if (X >= 0 && X < A.length && Y >= 0 && Y < A[0].length) {
                    if (!visited[X][Y] && A[X][Y].equals("#")) {
                        queue.add(new int[] {X, Y});
                        visited[X][Y] = true;
                    }
                }
            }
        }
    }
}
