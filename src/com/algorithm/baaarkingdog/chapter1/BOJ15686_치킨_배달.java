package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ15686_치킨_배달 {

    static int[][] map;
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static Position[] positions;
    static Position[] selected;
    static boolean[] visited;

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. 치킨집 좌표 구하기
        // 2. 치킨집 경우의수 백트래킹
        // 3. 경우의수마다 N * N

        map = new int[N][N];
        selected = new Position[M];


        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    count++;
                }
            }
        }

        positions = new Position[count];
        visited = new boolean[count];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    positions[idx] = new Position(j, i);
                    idx++;
                }
            }
        }


        for (int i = 0; i < positions.length; i++) {
            dfs(i, 0);
        }

        System.out.println(min);

    }

    static void dfs(int idx, int depth) {
        selected[depth] = positions[idx];
        visited[idx] = true;

        if (depth == M - 1) {
            // 총 거리 확인
            // 2500 * 100 = 250000
            int result = checkDist();
            if (min > result) min = result;

            visited[idx] = false;
            return;
        }

        for (int i = idx + 1; i < positions.length; i++) {
            dfs(i, depth + 1);
        }

        visited[idx] = false;
    }

    static int checkDist() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int result = Integer.MAX_VALUE;

                if (map[i][j] == 1) {
                    // 집을 발견했을 경우
                    for (int k = 0; k < M; k++) {
                        Position p = selected[k];
                        int dist = Math.abs(j - p.x) + Math.abs(i - p.y);
                        if (result > dist) result = dist;
                    }

                    sum += result;
                }
            }
        }

        return sum;
    }

}
