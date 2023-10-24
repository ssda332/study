package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ15683_감시 {

    static int N;
    static int M;
    static int[][] map;
    static int[][] checkMap;
    static boolean[][] visited;
    static CCTV[] cctvs;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        checkMap = new int[N][M];

        ArrayList<CCTV> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    list.add(new CCTV(j, i, map[i][j], 0));
                }

            }
        }

        cctvs = new CCTV[list.size()];

        for (int i = 0; i < list.size(); i++) {
            cctvs[i] = list.get(i);
        }

        dfs(0, -1);

        System.out.println(min);
    }

    static void dfs(int v, int depth) {
        if (depth == cctvs.length - 1) {
            // cctv 감시 방향 정해짐
            setRange();
            min = Math.min(min, getBlindSpot());
            return;
        }

        for (int i = 0; i < 4; i++) {
            cctvs[depth + 1].turn = i;
            dfs(i, depth + 1);
        }

    }

    static int getBlindSpot() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (checkMap[i][j] == 0) count++;
            }
        }

        return count;
    }

    static void setRange() {
        for (int i = 0; i < N; i++) {
            checkMap[i] = map[i].clone();
        }

        for (int i = 0; i < cctvs.length; i++) {
            int x = cctvs[i].x;
            int y = cctvs[i].y;
            int type = cctvs[i].type;
            int trun = cctvs[i].turn;
            checkMap[y][x] = type;

            range(x, y, type, trun);
        }
    }

    // 0 east 1 south 2 west 3 north
    static void range(int x, int y, int type, int turn) {
        for (int i = 0; i < 4; i++) {
            int position = i + turn;
            if (position >= 4) position = position - 4;

            if (i == 1) {
                if (type == 1 || type == 2 || type == 3 || type == 4) continue;
            } else if (i == 2) {
                if (type == 1 || type == 3) continue;
            } else if (i == 3) {
                if (type == 1 || type == 2) continue;
            }

            if (position == 0) {
                int start = x + 1;
                while (start < M) {
                    if (checkMap[y][start] == 6) break;
                    checkMap[y][start] = 7;
                    start++;
                }
            } else if (position == 1) {
                int start = y + 1;
                while (start < N) {
                    if (checkMap[start][x] == 6) break;
                    checkMap[start][x] = 7;
                    start++;
                }
            } else if (position == 2) {
                int start = x - 1;
                while (start >= 0) {
                    if (checkMap[y][start] == 6) break;
                    checkMap[y][start] = 7;
                    start--;
                }
            } else if (position == 3) {
                int start = y - 1;
                while (start >= 0) {
                    if (checkMap[start][x] == 6) break;
                    checkMap[start][x] = 7;
                    start--;
                }
            }
        }
    }

    static class CCTV {
        public int x;
        public int y;
        public int type;
        public int turn;

        public CCTV(int x, int y, int type, int turn) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.turn = turn;
        }
    }
}
