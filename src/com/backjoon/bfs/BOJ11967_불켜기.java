package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ11967_불켜기 {

    static int N;
    static int M;
    static ArrayList<int[]>[][] A;
    static boolean[][] visited;
    static boolean[][] isMove;
    static boolean[][] isLight;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1][N + 1];
        isLight = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        isMove = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[x][y].add(new int[] {a, b});
        }

        int answer = bfs();
        System.out.println(answer);

    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 1});
//        visited[1][1] = true;
        isLight[1][1] = true;
        int answer = 1;


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cy = poll[0];
            int cx = poll[1];

            // 불이 켜져있다면 방문할수 있었던 좌표 체크
            for (int i = 0; i < 4; i++) {
                int X = cx + dx[i];
                int Y = cy + dy[i];

                if (X < 1 || X > N || Y < 1 || Y > N) continue;

                isMove[Y][X] = true;
            }

            // 현재 지점에서 스위치 누르기
            for (int[] next : A[cy][cx]) {
                int X = next[1];
                int Y = next[0];

                if (!isLight[Y][X]) {
                    isLight[Y][X] = true;
                    answer++;
                }

                // 이전에 방문할수 있었던 곳이면 다시 돌아가서 탐색하기 위해 큐에 넣음
                if (isMove[Y][X] && !visited[Y][X]) {
                    queue.add(new int[] {Y, X});
                    visited[Y][X] = true;
                }
            }

            // 불켜진곳 방문
            for (int i = 0; i < 4; i++) {
                int X = cx + dx[i];
                int Y = cy + dy[i];

                if (X < 1 || X > N || Y < 1 || Y > N || visited[Y][X] || !isLight[Y][X]) continue;

                queue.add(new int[] {Y, X});
                visited[Y][X] = true;
            }
        }

        return answer;
    }
}
