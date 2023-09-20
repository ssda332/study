package com.backjoon.adhoc;

import java.io.*;
import java.util.*;

public class BOJ16956_늑대와_양 {

    static int R;
    static int C;
    static String[][] A;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean endFlag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        A = new String[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                A[i][j] = line.substring(j, j + 1);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j].equals("W") && !endFlag) {
                    bfs(j, i);
                }
            }
        }

        if (endFlag) {
            System.out.println(0);
        } else {
            System.out.println(1);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(A[i][j]);
                }
                System.out.println();
            }
        }

    }

    static void bfs(int wolfX, int wolfY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {wolfX, wolfY});
        boolean flag = false;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if (X >= 0 && X < C && Y >= 0 && Y < R) {
                    if (A[Y][X].equals(".")) {
                        queue.add(new int[] {X, Y});
                        A[Y][X] = "D";
                    } else if (!flag && A[Y][X].equals("S")) {
                        endFlag = true;
                        return;
                    }
                }
            }

            flag = true;
        }
    }

}


