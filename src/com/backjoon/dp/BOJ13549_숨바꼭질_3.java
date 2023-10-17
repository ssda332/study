package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ13549_숨바꼭질_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        } else if (N > K) {
            System.out.println(N - K);
            return;
        }

        int[][] DP = new int[100001][3];


        // DP[i][j] = i번째에 j번째 방법으로 도달했을때 걸린 시간 (j = 0, 1, 2)
        // DP[i][0] = DP[i - 1]
    }
}
