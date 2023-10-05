package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ5014_스타트링크 {

    static boolean[] visited;
    static int click = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()); // 총 F층
        int S = Integer.parseInt(st.nextToken()); // 걍호 층
        int G = Integer.parseInt(st.nextToken()); // 스타트링크 층
        int U = Integer.parseInt(st.nextToken()); // 위로 U층
        int D = Integer.parseInt(st.nextToken()); // 아래로 D층

        visited = new boolean[F + 1];

        Queue<int[]> queue = new LinkedList<>();
        visited[S] = true;
        queue.add(new int[] {S, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int up = poll[0] + U;
            int down = poll[0] - D;

            if (poll[0] == G) {
                System.out.println(poll[1]);
                return;
            }


            if (up >= 1 && up <= F && !visited[up]) {
                visited[up] = true;
                queue.add(new int[] {up, poll[1] + 1});
            }

            if (down >= 1 && down <= F && !visited[down]) {
                visited[down] = true;
                queue.add(new int[] {down, poll[1] + 1});
            }
        }

        System.out.println("use the stairs");

    }
}
