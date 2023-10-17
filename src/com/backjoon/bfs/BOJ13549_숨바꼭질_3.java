package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ13549_숨바꼭질_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] move = new int[] {2, -1, 1};

        if (N == K) {
            System.out.println(0);
            return;
        } else if (N > K) {
            System.out.println(N - K);
            return;
        }

        boolean[] dots = new boolean[1000001];

        dots[N] = true;

        PriorityQueue<Move> queue = new PriorityQueue();
        queue.add(new Move(N, 0));

        while (!queue.isEmpty()) {
            Move poll = queue.poll();
            if (poll.x == K) {
                System.out.println(poll.second);
                return;
            }


            for (int i = 0; i < 3; i++) {
                int moving = poll.x + move[i];
                if (move[i] == 2) moving = poll.x * 2;

                if (moving <= 0 || moving > 100000 || dots[moving]) continue;

                if (moving == poll.x * 2) {
                    queue.add(new Move(moving, poll.second));
                } else {
                    queue.add(new Move(moving, poll.second + 1));
                }
                dots[moving] = true;

            }

        }

    }

    static class Move implements Comparable<Move>{
        public int x;
        public int second;

        public Move(int x, int second) {
            this.x = x;
            this.second = second;
        }


        @Override
        public int compareTo(Move o) {

            if (this.second == o. second) {
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.second, o.second);
        }
    }
}
