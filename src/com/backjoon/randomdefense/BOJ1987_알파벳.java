package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1987_알파벳 {

    static int answer = 1;
    static int R;
    static int C;
    static boolean[] visited = new boolean[26];
    static Character[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new Character[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int depth) {
        int next = map[y][x] - 'A';
        visited[next] = true;
        if (answer < depth) answer = depth;

        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X < 0 || X >= C || Y < 0 || Y >= R) continue;
            int nextAlpha = map[Y][X] - 'A';
            if (visited[nextAlpha]) continue;

            dfs(X, Y, depth + 1);
        }

        visited[next] = false;

    }

}
