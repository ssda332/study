package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ14499_주사위_굴리기 {

    static int N;
    static int M;
    static class Dice {
        int[] faces;
        int r;
        int c;

        public Dice(int[] faces, int r, int c) {
            this.faces = faces;
            this.r = r;
            this.c = c;
        }

        /**
         * 북   0
         * 서  123 동
         * 남   4
         *ㅇ    5
         *
         *      0
         *     123
         *      4
         *      5
         *
         *      0
         *     235
         *      4
         *      1
         *
         *      0
         *     512
         *      4
         *      3
         *
         *      5
         *     103
         *      2
         *      4
         *
         *      2
         *     143
         *      5
         *      0
         */

        void move(int type) {
            if (type == 1) {
                int temp = faces[1];
                faces[1] = faces[2];
                faces[2] = faces[3];
                faces[3] = faces[5];
                faces[5] = temp;

                this.c++;
            } else if (type == 2) {
                int temp = faces[1];
                faces[1] = faces[5];
                faces[5] = faces[3];
                faces[3] = faces[2];
                faces[2] = temp;

                this.c--;
            } else if (type == 3) {
                int temp = faces[0];
                faces[0] = faces[5];
                faces[5] = faces[4];
                faces[4] = faces[2];
                faces[2] = temp;

                this.r--;
            } else {
                int temp = faces[0];
                faces[0] = faces[2];
                faces[2] = faces[4];
                faces[4] = faces[5];
                faces[5] = temp;

                this.r++;
            }
        }

        void setBottom(int val) {
            this.faces[2] = val;
        }

        int getBottom() {
            return this.faces[2];
        }

        int getTop() {
            return this.faces[5];
        }

    }

    public static void main(String[] args) throws IOException {
        // 0907
        // 1018
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice(new int[6], x, y);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int type = Integer.parseInt(st.nextToken());

            if (check(type, dice)) {
                dice.move(type);
                changeBottom(map, dice);
                printTop(sb, dice);
            }

        }

        System.out.println(sb);
    }

    static void printTop(StringBuilder sb, Dice dice) {
        sb.append(dice.getTop()).append("\n");
    }

    static void changeBottom(int[][] map, Dice dice) {
        if (map[dice.r][dice.c] == 0) {
            map[dice.r][dice.c] = dice.getBottom();
        } else {
            dice.setBottom(map[dice.r][dice.c]);
            map[dice.r][dice.c] = 0;
        }
    }

    static boolean check(int type, Dice dice) {
        if (type == 1 && dice.c + 1 < M) return true;
        else if (type == 2 && dice.c - 1 >= 0) return true;
        else if (type == 3 && dice.r - 1 >= 0) return true;
        else if (type == 4 && dice.r + 1 < N) return true;

        return false;
    }
}
