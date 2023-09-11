package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ17144_미세먼지_안녕 {

    static int R;
    static int C;
    static int T;
    static int[][] A;
    static int[][] B;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int airCleanerTop;
    static int airCleanerBottom;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        A = new int[R][C];
        B = new int[R][C];

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == -1) {
                    if (cnt == 0) {
                        airCleanerTop = i;
                        cnt++;
                    } else {
                        airCleanerBottom = i;
                    }
                }

            }
        }


        for (int i = 0; i < T; i++) {
            diffusion();
            /*for (int j = 0; j < R; j++) {
                System.out.println();
                for (int k = 0; k < C; k++) {
                    System.out.print(A[j][k] + " ");
                }
            }*/
            airCleaner();
        }

        /*for (int i = 0; i < R; i++) {
            System.out.println();
            for (int j = 0; j < C; j++) {
                System.out.print(A[i][j] + " ");
            }
        }*/

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] != -1) sum += A[i][j];
            }
        }

        System.out.println(sum);
    }

    static void airCleaner() {
        airCleaner_top(airCleanerTop);
        airCleaner_bottom(airCleanerBottom);

        copy();
        A[airCleanerTop][0] = -1;
        A[airCleanerBottom][0] = -1;
        B = new int[R][C];
    }

    static void diffusion() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {

                    int diff = A[i][j] / 5;
                    B[i][j] += A[i][j];
                    for (int k = 0; k < 4; k++) {
                        int x = j + dx[k];
                        int y = i + dy[k];
                        if (x >= 0 && y >= 0 && x < C && y < R && A[y][x] != -1) {
                            B[y][x] += diff;
                            B[i][j] -= diff;
                        }
                    }


                }
            }
        }

        copy();
        A[airCleanerTop][0] = -1;
        A[airCleanerBottom][0] = -1;
    }

    static void airCleaner_top(int y) {
        B[y][1] = 0;

        for (int i = 1; i < C - 1; i++) B[y][i + 1] = A[y][i];
        for (int i = y; i > 0; i--) B[i - 1][C - 1] = A[i][C - 1];
        for (int i = C - 1; i > 0; i--) B[0][i - 1] = A[0][i];
        for (int i = 0; i < y - 1; i++) B[i + 1][0] = A[i][0];
    }

    static void airCleaner_bottom(int y) {
        B[y][1] = 0;

        for (int i = 1; i < C - 1; i++) B[y][i + 1] = A[y][i];
        for (int i = y; i < R - 1; i++) B[i + 1][C - 1] = A[i][C - 1];
        for (int i = C - 1; i > 0; i--) B[R - 1][i - 1] = A[R - 1][i];
        for (int i = R - 1; i > y + 1; i--) B[i - 1][0] = A[i][0];
    }

    static void copy() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = B[i][j];
            }
        }
    }

}

