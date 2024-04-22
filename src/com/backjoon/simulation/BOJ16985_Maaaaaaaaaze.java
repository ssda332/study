package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ16985_Maaaaaaaaaze {

    static int[][][] maze;
    static int[][][] newMaze;
    static boolean[] visited;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;
    static class Coor {
        int x;
        int y;
        int z;
        int depth;

    public Coor(int x, int y, int z, int depth) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.depth = depth;
    }
}

    public static void main(String[] args) throws IOException {
        maze = new int[5][5][5];
        newMaze = new int[5][5][5];
        visited = new boolean[5];
        inputVal(maze);

        for (int i = 0; i < 5; i++) {
            setMaze(i, 0);
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);

    }

    static void inputVal(int[][][] maze) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int k = 0; k < 5; k++) {
                    maze[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }

        }
    }

    static void setMaze(int v, int depth) {
        for (int i = 0; i < 5; i++) {
            newMaze[depth][i] = maze[v][i].clone();
        }
        if (depth == 4) {
            // maze 완성되었으면 회전 경우의수 돌리기
            int[][][] tempMaze = getClone3();
            checkRotate(0);
            newMaze = tempMaze;
            return;
        }

        visited[v] = true;

        for (int i = 0; i < 5; i++) {
            if (visited[i]) continue;

            setMaze(i, depth + 1);
            visited[i] = false;
        }

        visited[v] = false;
    }

    static void checkRotate(int depth) {
        if (depth == 5) {
            checkDoor();
            return;
        }

        for (int i = 0; i < 4; i++) {
            rotate(depth);
            checkRotate(depth + 1);
        }
    }

    static void rotate(int k) {
        int[][] newMap = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                newMap[4 - j][i] = newMaze[k][i][j];
            }
        }

        newMaze[k] = newMap;
    }

    static void checkDoor() {
        if (answer == 12) return;

        if (newMaze[0][0][0] == 1 && newMaze[4][4][4] == 1) {
            answer = Math.min(answer, bfs(new Coor(0, 0, 0, 0)));
            answer = Math.min(answer, bfs(new Coor(4, 4, 4, 0)));
        }
        if (newMaze[0][4][4] == 1 && newMaze[4][0][0] == 1) {
            answer = Math.min(answer, bfs(new Coor(4, 4, 0, 0)));
            answer = Math.min(answer, bfs(new Coor(0, 0, 4, 0)));
        }
        if (newMaze[0][4][0] == 1 && newMaze[4][0][4] == 1) {
            answer = Math.min(answer, bfs(new Coor(0, 4, 0, 0)));
            answer = Math.min(answer, bfs(new Coor(4, 0, 4, 0)));
        }
        if (newMaze[0][0][4] == 1 && newMaze[4][4][0] == 1) {
            answer = Math.min(answer, bfs(new Coor(4, 0, 0, 0)));
            answer = Math.min(answer, bfs(new Coor(0, 4, 4, 0)));
        }
    }

    static int bfs(Coor coor) {
        boolean[][][] visited = new boolean[5][5][5];
        Queue<Coor> q = new LinkedList<>();
        q.add(coor);
        visited[coor.z][coor.y][coor.x] = true;

        while (!q.isEmpty()) {
            Coor poll = q.poll();
            if (poll.x == Math.abs(4 - coor.x) && poll.y == Math.abs(4 - coor.y) && poll.z == Math.abs(4 - coor.z)) {
                return poll.depth;
            }

            for (int i = 0; i < 6; i++) {
                int X = poll.x + dx[i];
                int Y = poll.y + dy[i];
                int Z = poll.z + dz[i];

                if (X < 0 || X >= 5 || Y < 0 || Y >= 5 || Z < 0 || Z >= 5) continue;
                if (visited[Z][Y][X] || newMaze[Z][Y][X] == 0) continue;

                q.add(new Coor(X, Y, Z, poll.depth + 1));
                visited[Z][Y][X] = true;
            }
        }

        return Integer.MAX_VALUE;

    }

    static int[][][] getClone3() {
        int[][][] cloned = new int[newMaze.length][][];
        for (int i = 0; i < newMaze.length; i++) {
            cloned[i] = new int[newMaze[i].length][];
            for (int j = 0; j < newMaze[i].length; j++) {
                cloned[i][j] = Arrays.copyOf(newMaze[i][j], newMaze[i][j].length);
            }
        }

        return cloned;
    }

}
