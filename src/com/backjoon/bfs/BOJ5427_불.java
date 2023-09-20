package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ5427_불 {

    static StringBuilder sb;
    static int w;
    static int h;
    static String[][] B;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean escape;

    public static void main(String[] args) throws IOException{
        // 시복도체크해보기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            B = new String[h][w];
            Queue<int[]> sq = new LinkedList<>();
            Queue<int[]> fq = new LinkedList<>();


            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    B[i][j] = line.substring(j, j + 1);
                    if (B[i][j].equals("@")) {
                        sq.add(new int[] {i, j});
                    } else if (B[i][j].equals("*")) {
                        fq.add(new int[] {i, j});
                    }
                }
            }

            bfs(sq, fq);

        }

        System.out.println(sb);
    }

    static void bfs(Queue<int[]> sq, Queue<int[]> fq) {
        escape = false;
        int second = 1;

        while (!sq.isEmpty()) {
            spread(fq, true, second);
            spread(sq, false, second);
            second++;

            if (escape) break;
        }

        if (!escape) {
            sb.append("IMPOSSIBLE").append("\n");
        }
    }

    static void spread(Queue<int[]> queue, boolean isFire, int second) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int[] poll = queue.poll();
            for (int j = 0; j < 4; j++) {
                int X = poll[1] + dx[j];
                int Y = poll[0] + dy[j];

                if (X >= 0 && X < w && Y >= 0 && Y < h) {
                    if (B[Y][X].equals(".")) {
                        if (isFire) {
                            B[Y][X] = "*";
                        } else {
                            B[Y][X] = "@";
                        }
                        queue.add(new int[] {Y, X});
                    }
                } else if ((X < 0 || X >= w || Y < 0 || Y >= h) && !isFire) {
                    sb.append(second).append("\n");
                    escape = true;
                    return;
                }
            }
        }
    }

}
