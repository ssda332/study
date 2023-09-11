package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1996_지뢰_찾기 {

    static String[][] map;
    static String[][] result;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        result = new String[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.substring(j, j + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals(".")) {
                    int num = 0;

                    for (int k = 0; k < 8; k++) {
                        int X = dx[k] + j;
                        int Y = dy[k] + i;

                        if (X >= 0 && X < N && Y >= 0 && Y < N) {
                            if (!map[Y][X].equals(".")) {
                                int boom = Integer.parseInt(map[Y][X]);
                                num += boom;
                            }
                        }
                    }

                    if (num < 10) {
                        result[i][j] = num + "";
                    } else {
                        result[i][j] = "M";
                    }
                } else {
                    result[i][j] = "*";
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);



    }
}
