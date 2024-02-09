package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1647_도시_분할_계획 {

    static int N;
    static int M;
    static int[] parents;
    static ArrayList<Road> A;
    static boolean[] visited;

    static class Road implements Comparable<Road>{
        int from;
        int to;
        int cost;

        public Road(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();
        visited = new boolean[N + 1];
        parents = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            A.add(new Road(from, to, cost));
        }

        Collections.sort(A);

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        System.out.println(kruskal());

    }

    static int kruskal() {
        int answer = 0;
        int max = 0;

        for (int i = 0; i < A.size(); i++) {
            Road road = A.get(i);

            if (find(road.from) != find(road.to)) {
                answer += road.cost;
                union(road.from, road.to);

                max = road.cost;
            }
        }

        return answer - max;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
        }
    }

    static int find(int v) {
        if (parents[v] == v) return v;

        return parents[v] = find(parents[v]);
    }


}
