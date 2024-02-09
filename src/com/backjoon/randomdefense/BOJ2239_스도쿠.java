package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ2239_스도쿠 {

    static int[][] sudoku;
    static ArrayList<int[]> A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        A = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int el = Integer.parseInt(line.substring(j, j + 1));
                sudoku[i][j] = el;

                if (el == 0) {
                    A.add(new int[] {j, i});
                }
            }
        }

        go(0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean go(int cnt) {
        if (A.size() == cnt) return true;

        int[] position = A.get(cnt);
        int x = position[0];
        int y = position[1];

        for (int i = 1; i <= 9; i++) {
            sudoku[y][x] = i;
            if(dupCheck(x, y, i) && go(cnt + 1)) return true;
        }

        sudoku[y][x] = 0;

        return false;
    }

    static boolean dupCheck(int x, int y, int v) {
        int startX = makeAreaInit(x);
        int startY = makeAreaInit(y);

        for (int i = 0; i < 9; i++) {
            if (i != y && sudoku[i][x] == v) return false;
            if (i != x && sudoku[y][i] == v) return false;
        }

        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (x == j && y == i) continue;
                if (sudoku[i][j] == v) return false;
            }
        }

        return true;
    }

    static int makeAreaInit(int v) {
        if (v % 3 == 0) return v;
        else if (v % 3 == 1) return v - 1;
        else return v - 2;
    }
}
