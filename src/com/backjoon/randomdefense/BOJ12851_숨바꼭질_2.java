package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ12851_숨바꼭질_2 {

    static int N;
    static int K;
    static int[] time;
    static int[] move = new int[] {-1, 1, 2};
    static int result = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);

        bfs();
        System.out.println(result);
        System.out.println(count);

    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (result < time[current]) return;

            if (current == K) {
                count++;
                result = time[current];
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (move[i] == 2) {
                    next = current * 2;
                } else {
                    next = current + move[i];
                }

                if (next < 0 || next > 100000) continue;
                if (time[current] + 1 > time[next]) continue;

                queue.add(next);
                time[next] = time[current] + 1;
            }
        }
    }
}
