package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_연구소 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] A;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);

    }

    static void bfs(int i, int j, int[][] B) {
        //0921
        // 1 벽 2 바이러스

                if (B[i][j] == 2) {

                    Queue<int[]> queue = new LinkedList<>();
                    int[] xy = {i, j};
                    queue.add(xy);

                    while(!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int X = dx[k] + poll[1];
                            int Y = dy[k] + poll[0];

                            if (X >= 0 && X < M && Y >= 0 && Y < N ) {
                                if (B[Y][X] == 0) {
                                    queue.add(new int[] {Y, X});
                                    B[Y][X] = 2;
                                }
                            }
                        }
                    }

                }

    }

    static void dfs(int depth) { // 0부터 시작
        if (depth == 3) {

            int[][] B = new int[N][M];
            for (int i = 0; i < N; i++) {
                B[i] = A[i].clone();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    bfs(i, j, B);
                }
            }

            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (B[i][j] == 0) {
                        count++;
                    }
                }
            }

            if (count > result) {
                result = count;
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
//                    System.out.println("i : " + i + ", j : " + j + ", depth : " + depth);
                    A[i][j] = 1;
                    dfs(depth + 1);
                    A[i][j] = 0;
                }
            }
        }
    }
}
