package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ16946_벽_부수고_이동하기_4 {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] groups;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Map<Integer, Integer> groupSize = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int X;
        int Y;

        public Node(int x, int y) {
            X = x;
            Y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        groups = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        int count = 1;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    makeGroups(i, j, count++);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Map<Integer, Integer> visited2 = new HashMap<>();

                int answer = 0;

                if (map[i][j] == 1) {
                    answer++;
                    for (int k = 0; k < 4; k++) {
                        int X = j + dx[k];
                        int Y = i + dy[k];

                        if (X < 0 || X >= M || Y < 0 || Y >= N) continue;
                        if (groups[Y][X] != 0 && !visited2.containsKey(groups[Y][X])) {
                            answer += groupSize.get(groups[Y][X]);
                            visited2.put(groups[Y][X], 0);
                        }
                    }
                }

                map[i][j] = answer % 10;
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void makeGroups(int y, int x, int count) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[y][x] = true;
        groups[y][x] = count;

        int size = 1;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll.X + dx[i];
                int Y = poll.Y + dy[i];

                if (X < 0 || X >= M || Y < 0 || Y >= N) continue;
                if (visited[Y][X] || map[Y][X] == 1) continue;

                visited[Y][X] = true;
                groups[Y][X] = count;
                queue.add(new Node(X, Y));
                size++;
            }
        }

        groupSize.put(count, size);
    }


}
