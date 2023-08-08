package com.backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926_그림 {

    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j] && A[i][j] == 1) {
                    int area = bfs(i, j);
                    cnt++;
//                    System.out.println(i + ", " + j);

                    if (area > max) {
                        max = area;
                    }
                }

            }
        }

        System.out.println(cnt);
        System.out.println(max);

    }

    static int bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        int[] e = {n , m};
        queue.add(e);
        visited[n][m] = true;

        int max = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];
//                System.out.println(A.length);
//                System.out.println(A[1].length);

                if (!(x < 1 || x > A.length - 1 || y < 1 || y > A[1].length - 1)) {
                    if (A[x][y] == 1 && !visited[x][y]) {
//                        System.out.println("x : " + x + ", y : " + y);
                        queue.add(new int[] {x, y});
                        visited[x][y] = true;
                        max++;
                    }
                }

            }

        }

        return max;
    }
}
