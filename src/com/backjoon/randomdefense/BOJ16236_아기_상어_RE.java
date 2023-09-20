package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ16236_아기_상어_RE {
    static int N;
    static int startX, startY, eat, answer = 0;
    static int size = 2;
    static int[][] A;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

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

        while(true) {
            int beforeEat = eat;
            bfs(startX, startY, 0);

            if (beforeEat == eat) break;
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y, int dist) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] - o2[2] != 0) {
                    return o1[2] - o2[2];
                }

                if (o1[1] - o2[1] != 0) {
                    return o1[1] - o2[1];
                }

                return o1[0] - o2[0];
            }

        });
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[] {x, y, dist});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int curDist = poll[2];

            if (A[curY][curX] > 0 && A[curY][curX] < size) {
                A[curY][curX] = 0;
                answer += curDist;
                startX = curX;
                startY = curY;
                eat++;
                if (eat == size) {
                    eat = 0;
                    size++;
                }
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextY][nextX] && A[nextY][nextX] <= size) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[] {nextX, nextY, curDist + 1});
                }
            }


        }

    }
}
