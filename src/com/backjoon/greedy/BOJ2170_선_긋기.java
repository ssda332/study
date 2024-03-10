package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ2170_선_긋기 {

    static class Node implements Comparable<Node>{
        int val;
        int type;

        public Node(int val, int type) {
            this.val = val;
            this.type = type;
        }

        @Override
        public int compareTo(Node o) {
            if (this.val == o.val) return Integer.compare(this.type, o.type);
            return Integer.compare(this.val, o.val);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Node(start, 0));
            queue.add(new Node(end, 1));
        }

        int start = 0;
        int startNum = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.type == 0) start++;
            else start--;

            if (start == 1 && poll.type == 0) {
                startNum = poll.val;
            } else if (start == 0) {
                answer += (poll.val - startNum);
            }
        }

        System.out.println(answer);
    }
}
