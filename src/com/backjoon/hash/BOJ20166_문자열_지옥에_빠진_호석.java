package com.backjoon.hash;

import java.io.*;
import java.util.*;

public class BOJ20166_문자열_지옥에_빠진_호석 {

    static int N;
    static int M;
    static int K;
    static String[][] map;
    static Map<String, Integer> memo;
    static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
    static int count;
    static StringBuilder sb = new StringBuilder();
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        memo = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.substring(j, j + 1);
            }
        }

        for (int i = 0; i < K; i++) {
            String s = br.readLine();

            if (memo.containsKey(s)) {
                sb.append(memo.get(s)).append("\n");
                continue;
            }

            Map<Integer, String> str = new HashMap<>();
            length = s.length() - 1;
            for (int j = 0; j <= length; j++) {
                str.put(j, s.substring(j, j + 1));
            }

            count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    String start = map[j][k];

                    dfs(start, k, j, str, 0);
                }
            }
            memo.put(s, count);
            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(String start, int x, int y, Map<Integer, String> str, int depth) {
        if (start.equals(str.get(depth))) {
            if (length == depth) {
                count++;
                return;
            }
        } else {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if (X == -1) X = M - 1;
            if (X == M) X = 0;
            if (Y == -1) Y = N - 1;
            if (Y == N) Y = 0;

            String next = map[Y][X];
            dfs(next, X, Y, str, depth + 1);
        }
    }
}
