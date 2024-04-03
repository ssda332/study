package com.backjoon.dfs;

import java.io.*;
import java.util.*;
import java.util.function.BiFunction;

public class BOJ9019_DSLR {

    static int A;
    static int B;
    static String[] command;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = parseInt(st.nextToken());
            B = parseInt(st.nextToken());
            visited = new boolean[10000];
            command = new String[10000];
            Arrays.fill(command, "");

            bfs();
            sb.append(command[B]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        visited[A] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            int D = poll * 2 % 10000;
            int S = (poll == 0) ? 9999 : poll - 1;
            int L = (poll % 1000) * 10 + poll / 1000;
            int R = (poll % 10) * 1000 + poll / 10;

            if (!visited[D]) {
                q.add(D);
                visited[D] = true;
                command[D] = command[poll] + "D";
            }

            if (!visited[S]) {
                q.add(S);
                visited[S] = true;
                command[S] = command[poll] + "S";
            }

            if (!visited[L]) {
                q.add(L);
                visited[L] = true;
                command[L] = command[poll] + "L";
            }

            if (!visited[R]) {
                q.add(R);
                visited[R] = true;
                command[R] = command[poll] + "R";
            }

        }
    }

    static int parseInt(String n) {
        return Integer.parseInt(n);
    }

}
