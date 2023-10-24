package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ16928_뱀과_사다리_게임 {

    static boolean[] visited = new boolean[101];
    static int[] dice = new int[] {1, 2, 3, 4, 5, 6};
    static ArrayList<Integer>[] ladderAndSnake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ladderAndSnake = new ArrayList[101];

        for (int i = 0; i < ladderAndSnake.length; i++) {
            ladderAndSnake[i] = new ArrayList<>();
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladderAndSnake[start].add(end);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int count = poll[1];

            for (int i = 0; i < 6; i++) {
                int move = current + dice[i];

                if (move > 100 || visited[move]) continue;
                if (move == 100) {
                    System.out.println(count + 1);
                    return;
                }

                if (!ladderAndSnake[move].isEmpty()) {
                    int next = ladderAndSnake[move].get(0);
                    if (next <= 100) {
                        visited[next] = true;
                        queue.add(new int[] {next, count + 1});
                    }
                } else {
                    queue.add(new int[] {move, count + 1});
                    visited[move] = true;
                }

            }
        }
    }
}
