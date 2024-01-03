package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ17071_숨바꼭질_5 {

    static boolean[][] visited = new boolean[500001][2];
    static int[] dx = {-1, 1, 2};
    static int answer = -1;

    static class Node {
        int p;
        int type;
        int time;

        public Node(int p, int type, int time) {
            this.p = p;
            this.type = type;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0, 0));
        queue.add(new Node(K, 1, 0));
        visited[N][0] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.type == 0) { // 수빈
                for (int i = 0; i < 3; i++) {
                    int next;
                    if (i != 2) next = poll.p + dx[i];
                    else next = poll.p * dx[i];
                    int oddOrEven = (poll.time + 1) % 2;

                    if (next < 0 || next > 500000 || visited[next][oddOrEven]) continue;

                    queue.add(new Node(next, 0, poll.time + 1));
                    visited[next][oddOrEven] = true;

                }
            } else { // 동생
                /*for (int i = 0; i < 2; i++) {
                    int next = poll.p + dx[i] * (poll.time + 1);
                    int oddOrEven = (poll.time + 1) % 2;

                    if (next < 0 || next > 500000) continue;
                    if (visited[next][oddOrEven]) {
                        answer = poll.time + 1;
                        System.out.println(answer);
                        return;
                    }

                    queue.add(new Node(next, 1, poll.time + 1));
                }*/
                int next = poll.p + poll.time + 1;
                int oddOrEven = (poll.time + 1) % 2;

                if (next < 0 || next > 500000) continue;

                if (visited[next][oddOrEven]) {
                    answer = poll.time + 1;
                    System.out.println(answer);
                    return;
                }

                queue.add(new Node(next, 1, poll.time + 1));

            }
        }

        System.out.println(answer);

    }
}
