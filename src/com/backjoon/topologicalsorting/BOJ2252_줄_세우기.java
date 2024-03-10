package com.backjoon.topologicalsorting;

import java.io.*;
import java.util.*;

public class BOJ2252_줄_세우기 {

    static int N;
    static int M;
    static int[] indegree;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            A[front].add(back);
            indegree[back]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int front = queue.poll();

            for (int back : A[front]) {
                if (indegree[back] <= 0) continue;
                if (--indegree[back] == 0) {
                    queue.add(back);
                }
            }

            sb.append(front).append(" ");
        }

        System.out.println(sb);


    }
}
