package com.backjoon.graph;

import java.io.*;
import java.util.*;

public class BOJ2660_회장뽑기 {

    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] checkList;

    static class Member {
        int target;
        int depth;

        public Member(int target, int depth) {
            this.target = target;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        checkList = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if (X == -1 && Y == -1) break;

            A[X].add(Y);
            A[Y].add(X);
        }

        int min = Integer.MAX_VALUE;
        int size = 0;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int rank = bfs(i, 1);

            if (rank < min) {
                size = 1;
                min = rank;
            } else if (rank == min) {
                size++;
            }
            checkList[i] = rank;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(size).append("\n");

        for (int i = 1; i <= N; i++) {
            if (checkList[i] == min) sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

    static int bfs(int start, int rank) {
        Queue<Member> queue = new LinkedList<>();
        queue.add(new Member(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Member poll = queue.poll();
            if (poll.depth > rank) rank = poll.depth;

            for (int target : A[poll.target]) {
                if (visited[target]) continue;

                visited[target] = true;
                queue.add(new Member(target, poll.depth + 1));
            }
        }

        return rank;
    }
}
