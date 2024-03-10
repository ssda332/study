package com.backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325_효율적인_해킹 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n = 10000 m = 100000

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            ans[i] = -1;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            A[start].add(end);
        }

        for (int i = 1; i <= N; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(i);

            int cnt = 0;

            while (!stack.isEmpty()) {
                int pop = stack.pop();
                ans[pop] = 0;

                for (int next : A[pop]) {
                    if (ans[next] == -1) {
                        ans[i]++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int max = 0;
        for(int i : ans) {
            max = Math.max(max, i);
        }

        for (int i = 1; i <= N; i++) {
            if (ans[i] == max) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);

    }


}
