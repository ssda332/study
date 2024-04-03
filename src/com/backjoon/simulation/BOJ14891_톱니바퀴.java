package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ14891_톱니바퀴 {

    static class Gear {
        int type;
        int[] sawtooth;

        public Gear(int type, int[] sawtooth) {
            this.type = type;
            this.sawtooth = sawtooth;
        }

        Integer getLeftSawtooth() {
            return sawtooth[6];
        }

        Integer getRightSawtooth() {
            return sawtooth[2];
        }

        void rotateCounterclockwise() {
            int temp = sawtooth[0];

            for (int i = 1; i < 8; i++) {
                sawtooth[i - 1] = sawtooth[i];
            }

            sawtooth[7] = temp;
        }

        void rotateClockwise() {
            int temp = sawtooth[7];
            int[] newSawtooth = {sawtooth[7], sawtooth[0], sawtooth[1], sawtooth[2], sawtooth[3], sawtooth[4], sawtooth[5], sawtooth[6]};

            sawtooth = newSawtooth;
        }
    }
    static Gear[] gears;
    static int[] rotate;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new Gear[5];

        for (int i = 1; i <= 4; i++) {
            String s = br.readLine();
            int[] sawtooth = new int[8];
            for (int j = 0; j < 8; j++) {
                sawtooth[j] = s.charAt(j) - '0';
            }

            gears[i] = new Gear(i, sawtooth);
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotate = new int[5];

            if (dir == -1) {
                rotateFlow(N, false, true, true);
            } else {
                rotateFlow(N, true, true, true);
            }

            rotate();
        }

        System.out.println(getScore());
    }

    static boolean checkSawtooth(int n) {
        int c1;
        int c2;

        if (n == 1) {
            c1 = gears[1].getRightSawtooth();
            c2 = gears[2].getLeftSawtooth();
        } else if (n == 2) {
            c1 = gears[2].getRightSawtooth();
            c2 = gears[3].getLeftSawtooth();
        } else {
            c1 = gears[3].getRightSawtooth();
            c2 = gears[4].getLeftSawtooth();
        }

        return (c1 == c2 ? false : true);
    }

    // -1 반시계 false, 1 시계 true
    static void rotateFlow(int n, boolean type, boolean isLeft, boolean isRight) {
        int left = n - 1;
        int right = n + 1;

        if (left >= 1 && isLeft) {
            if (checkSawtooth(left)) {
                rotateFlow(left, !type, true, false);
            }

        }

        if (right <= 4 && isRight) {
            if (checkSawtooth(right - 1)) {
                rotateFlow(right, !type, false, true);
            }
        }

        // 회전
        if (type) {
            rotate[n] = 1;
        } else {
            rotate[n] = -1;
        }

    }

    static void rotate() {
        for (int i = 1; i <= 4; i++) {
            if (rotate[i] == -1) {
                gears[i].rotateCounterclockwise();
            } else if (rotate[i] == 1){
                gears[i].rotateClockwise();
            }
        }
    }

    static int getScore() {
        int score = 0;
        if (gears[1].sawtooth[0] == 1) score += 1;
        if (gears[2].sawtooth[0] == 1) score += 2;
        if (gears[3].sawtooth[0] == 1) score += 4;
        if (gears[4].sawtooth[0] == 1) score += 8;

        return score;
    }
}
