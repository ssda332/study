package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ12865_평범한_배낭 {

    static class Stuff {
        int cost;
        int weight;

        public Stuff(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }
    }

    static int N;
    static int K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Stuff[] stuffs = new Stuff[N + 1];
        int[][] DP = new int[N + 1][K + 1];
        // DP[i][j] = i번째 물건까지 j키로에 담을수 있는 최대금액

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            stuffs[i] = new Stuff(cost, weight);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - stuffs[i].weight < 0) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - stuffs[i].weight] + stuffs[i].cost);
                }

            }
        }

        System.out.println(DP[N][K]);

    }
}
