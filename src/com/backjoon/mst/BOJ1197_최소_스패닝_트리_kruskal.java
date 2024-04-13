package com.backjoon.mst;

import java.io.*;
import java.util.*;

public class BOJ1197_최소_스패닝_트리_kruskal {

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int[] parents;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parents = new int[V + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Node(from, to, cost));
        }

        Collections.sort(list);
        int answer = kruskal();

        System.out.println(answer);
    }

    static int kruskal() {
        int result = 0;

        for (Node node : list) {
            int fromParent = find(node.from);
            int toParent = find(node.to);

            if (fromParent == toParent) continue;
            result += node.cost;
            parents[toParent] = fromParent;
        }

        return result;
    }

    static int find(int v) {
        if (parents[v] == v) return v;

        return parents[v] = find(parents[v]);
    }
}
