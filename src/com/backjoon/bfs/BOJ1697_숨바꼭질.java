package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ1697_숨바꼭질 {

    public static void main(String[] args) throws IOException{
        int[] map = new int[100001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        map[N] = -1;
        map[K] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int depth = poll[1];

            int[] dx = {x - 1, x + 1, x * 2};

            for (int i = 0; i < 3; i++) {
                if (dx[i] >= 0 && dx[i] <= 100000) {
                    if (map[dx[i]] == 0) {
                        map[dx[i]] = -1;
                        queue.add(new int[] {dx[i], depth + 1});
                    } else if (map[dx[i]] == 1){
                        System.out.println(depth + 1);
                        return;
                    }
                }
            }
        }


    }
}
