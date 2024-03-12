package com.backjoon.topologicalsorting;

import java.io.*;
import java.util.*;

public class BOJ2623_음악프로그램 {

    static int N;
    static int M;
    static ArrayList<Integer>[] A;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            for (int j = 1; j < length; j++) {
                int end = Integer.parseInt(st.nextToken());
                A[start].add(end);
                indegree[end]++;
                start = end;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int next : A[poll]) {
                if (indegree[next] <= 0) continue;
                if (--indegree[next] == 0) queue.add(next);
            }

            sb.append(poll).append("\n");
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] > 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(sb);

    }
}
