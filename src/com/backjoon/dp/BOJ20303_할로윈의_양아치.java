package com.backjoon.dp;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BOJ20303_할로윈의_양아치 {

    static int N;
    static int M;
    static int K;
    static int[] candies;
    static int[] parents;
    static ArrayList<Group> list;
    static StringTokenizer st;
    static long[][] DP;

    static class Group {
        int num;
        int candy;

        public Group(int num, int candy) {
            this.num = num;
            this.candy = candy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        candies = new int[N + 1];
        parents = new int[N + 1];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        IntStream.range(1, N + 1).forEach(i -> candies[i] = Integer.parseInt(st.nextToken()));
        IntStream.range(1, N + 1).forEach(i -> parents[i] = i);
//        System.out.println(Arrays.toString(candies));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        makeList();
        DP = new long[list.size() + 1][K]; // i번째 그룹까지 순회해 K명의 아이가 울때 사탕 뺏은 최대값

        for (int i = 1; i <= list.size(); i++) {

            int num = list.get(i - 1).num;
            int candy = list.get(i - 1).candy;

            for (int j = 1; j < K; j++) {
                if (j - num < 0) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - num] + candy);
                }
            }
        }

        System.out.println(DP[list.size()][K - 1]);
    }

    static void makeList() {
        Map<Integer, Group> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (parents[i] == i) map.put(i, new Group(1, candies[i]));
        }

        for (int i = 1; i <= N; i++) {
            if (parents[i] != i) {
                int parent = find(parents[i]);
                map.get(parent).num++;
                map.get(parent).candy += candies[i];
            }
        }

        list = new ArrayList<>(map.values());
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parents[y] = x;
    }

    static int find(int v) {
        if (parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }


}
