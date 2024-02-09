package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ2342_Dance_Dance_Revolution {

    static final int INF = 99999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        int token = Integer.parseInt(st.nextToken());

        while (token != 0) {
            list.add(token);
            token = Integer.parseInt(st.nextToken());
        }

        int[][][] DP = new int[list.size()][5][5];
        // DP[i][j][k] = i번째 이동에서 발이 (j, k)에 있을때 드는 최소 힘

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    DP[i][j][k] = INF;
                }
            }
        }

        DP[0][0][0] = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            int next = list.get(i + 1); // 이동해야하는 자리

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    int cur = DP[i][j][k];
//                    if (cur == INF) continue;

                    DP[i + 1][next][k] = Math.min(DP[i + 1][next][k], cur + move(j, next));
                    DP[i + 1][j][next] = Math.min(DP[i + 1][j][next], cur + move(k, next));
/*                    if (next != j) {
                        DP[i + 1][j][next] = Math.min(DP[i + 1][j][next], cur + move(j, next));
                    }

                    if (next != k) {
                        DP[i + 1][next][k] = Math.min(DP[i + 1][next][k], cur + move(k, next));
                    }*/
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, DP[list.size() - 1][i][j]);
            }
        }

        System.out.println(answer);
    }

    static int move(int cur, int next) {
        if (cur == next) return 1;
        else if (cur == 0) return 2;
        else if (Math.abs(cur - next) == 1) return 3;
        else if (cur == 1 && next == 4) return 3;
        else if (cur == 4 && next == 1) return 3;
        else return 4;
    }
}
