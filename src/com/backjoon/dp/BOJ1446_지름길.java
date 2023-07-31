package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1446_지름길 {

    static int[] DP;
    static int[][] shortcut;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        DP = new int[D + 1];
        shortcut = new int[N][3];

        // D[i] = D[i + 1] + 1 지름길이 없을때
        // D[i]

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            shortcut[i][0] = Integer.parseInt(st.nextToken());
            shortcut[i][1] = Integer.parseInt(st.nextToken());
            shortcut[i][2] = Integer.parseInt(st.nextToken());
        }



        // DP[i] =


    }
}
