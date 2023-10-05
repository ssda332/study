package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ19942_다이어트 {

    static int N;
    static Food[] A;
    static int mp;
    static int mf;
    static int ms;
    static int mv;
    static int sum = Integer.MAX_VALUE;
    static boolean[] visited;
    static boolean[] routes;
    static boolean flag = true;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        A = new Food[N];
        visited = new boolean[N];
        routes = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            A[i] = new Food(p, f, s, v, price);
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            dfs(i, A[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");

        for (int i = 0; i < N; i++) {
            if (routes[i]) {
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb);

    }

    static void dfs(int v, Food sumFood) {
        visited[v] = true;

        if (mp < sumFood.p && mf < sumFood.f && ms < sumFood.s && mv < sumFood.v && sum > sumFood.price) {
            sum = sumFood.price;
            routes = visited.clone();
        }

        for (int i = v + 1; i < N; i++) {
            dfs(i, sumFood.sum(A[i]));
//            if (!flag) return;
            visited[v] = false;
        }
    }

    static class Food implements Comparable<Food>{
        public int p;
        public int f;
        public int s;
        public int v;
        public int price;

        public Food(int p, int f, int s, int v, int price) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.price = price;
        }

        public Food sum(Food o) {
            return new Food(this.p + o.p, this.f + o.f, this.s + o.s, this.v + o.v, this.price + o.price);
        }

        @Override
        public int compareTo(Food o) {
            return Integer.compare(this.price, o.price);
        }
    }

}
