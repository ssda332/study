package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ9328_열쇠 {

    static int H;
    static int W;
    static char[][] map;
    static int[] key;
    static boolean[][] visited;
    static ArrayList<Node> doors;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Node> queue;
    static int answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H + 2][W + 2];
            visited = new boolean[H + 2][W + 2];
            key = new int[26];
            queue = new LinkedList<>();
            answer = 0;
            doors = new ArrayList<>();

            for (int i = 0; i < H + 2; i++) {
                String line = "";
                if (i != 0 && i != H + 1) line = br.readLine();

                for (int j = 0; j < W + 2; j++) {
                    if (i == 0 || i == H + 1 || j == 0 || j == W + 1) {
                        map[i][j] = '.';
                    } else {
                        map[i][j] = line.charAt(j - 1);
                    }
                }
            }

            String alpha = br.readLine();
            if (!alpha.equals("0")) {
                for (int i = 0; i < alpha.length(); i++) {
                    int num = alpha.charAt(i) - 'a';
                    key[num]++;
                }
            }

            bfs();
            sb.append(answer).append("\n");

        }

        System.out.println(sb);
    }

    static void moveCheck(int i, int j) {
        int alphaCheck = map[i][j] - 'A';
        int keyCheck = map[i][j] - 'a';

        if (map[i][j] == '.') {
            queue.add(new Node(j, i));
            visited[i][j] = true;
        } else if (alphaCheck >= 0 && alphaCheck <= 25){ // 문일때
            if (key[alphaCheck] > 0) {
                queue.add(new Node(j, i));
                visited[i][j] = true;
            } else {
                doors.add(new Node(j, i));
            }
        } else if (keyCheck >= 0 && keyCheck <= 25) { // 키일때
            for (int k = 0; k < doors.size(); k++) {
                Node node = doors.get(k);
                int x = node.x;
                int y = node.y;
                if (map[y][x] - 'A' == keyCheck) {
                    queue.add(new Node(x, y));
                }
            }

            key[keyCheck]++;
            queue.add(new Node(j, i));
            visited[i][j] = true;
        } else if (map[i][j] == '$') {
            answer++;
            queue.add(new Node(j, i));
            visited[i][j] = true;
        }
    }

    static void bfs() {
        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];

                if (X < 0 || X >= W + 2 || Y < 0 || Y >= H + 2) continue;
                if (visited[Y][X]) continue;

                moveCheck(Y, X);
            }
        }

    }
}
