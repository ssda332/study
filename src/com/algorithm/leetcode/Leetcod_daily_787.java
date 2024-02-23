package com.algorithm.leetcode;

import java.util.*;

public class Leetcod_daily_787 {

    static int n = 4;
//    static int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
    static int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
    static int src = 0;
    static int dst = 3;
    static int k = 1;

    static int[] D;
    static ArrayList<Route>[] A;
    static class Route {
        int e;
        int p;

        public Route(int e, int p) {
            this.e = e;
            this.p = p;
        }

    }

    static class Node {
        int e;
        int p;
        int d;

        public Node(int e, int p, int d) {
            this.e = e;
            this.p = p;
            this.d = d;
        }

    }

    static boolean[] visited;

    public static void main(String[] args) {

        A = new ArrayList[n];
        D = new int[n];
        visited = new boolean[n];
        Arrays.fill(D, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int s = flights[i][0];
            int e = flights[i][1];
            int p = flights[i][2];

            A[s].add(new Route(e, p));
        }

        dijkstra();
        System.out.println(D[dst] == Integer.MAX_VALUE ? -1 : D[dst]);
    }

    static void dijkstra() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, 0, 0));
        D[src] = 0;
        int count = 0;

        while (!queue.isEmpty() && count <= k) {
            int size = queue.size();

            while (size-- > 0) {
                Node poll = queue.poll();

                for (Route route : A[poll.e]) {
                    int target = route.e;
                    int price = route.p;

                    if (D[target] > poll.p + price) {
                        D[target] = poll.p + price;
                        queue.add(new Node(target, D[target], poll.d + 1));
                    }
                }
            }

            count++;
        }
    }
}
