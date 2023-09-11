package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070_파이프_옮기기_1 {

    static int N;
    static int[][] A;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][N + 1];
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dfs
        dfs(2, 1, true, false);
        System.out.println(result);

    }

    static void dfs(int x, int y, boolean xDiag, boolean yDiag) {
        if (x == N && y == N) {
//            System.out.println("x : " + x + ", y : " + y);
            result++;
            return;
        }

        if (x < N && y < N) {
            if (A[y][x + 1] != 1 && A[y + 1][x + 1] != 1 && A[y + 1][x] != 1) {
//                System.out.println("x : " + (x + 1) + ", y : " + (y + 1));
                dfs(x + 1, y + 1, true, true);
            }
        }

        if (yDiag && y + 1 <= N) {
            if (A[y + 1][x] != 1) {
//                System.out.println("x : " + x + ", y : " + (y + 1));
                dfs(x, y + 1, false, true);
            }
        }

        if (xDiag && x + 1 <= N) {
            if (A[y][x + 1] != 1) {
//                System.out.println("x : " + (x + 1) + ", y : " + y);
                dfs(x + 1, y, true, false);
            }
        }


    }
}
