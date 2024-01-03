package com.backjoon.deque;

import java.io.*;
import java.util.*;

public class BOJ10866_덱 {

    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            operation(st);
        }

        System.out.println(sb);
    }

    static void operation(StringTokenizer st) {
        String com = st.nextToken();

        if (com.equals("push_front")) {
            int val = Integer.parseInt(st.nextToken());
            deque.addFirst(val);
        } else if (com.equals("push_back")) {
            int val = Integer.parseInt(st.nextToken());
            deque.addLast(val);
        } else if (com.equals("pop_front")) {
            if (deque.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                int val = deque.removeFirst();
                sb.append(val).append("\n");
            }
        } else if (com.equals("pop_back")) {
            if (deque.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                int val = deque.removeLast();
                sb.append(val).append("\n");
            }
        } else if (com.equals("size")) {
            int val = deque.size();
            sb.append(val).append("\n");
        } else if (com.equals("empty")) {
            if (deque.isEmpty()) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        } else if (com.equals("front")) {
            if (deque.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(deque.peekFirst()).append("\n");
            }
        } else if (com.equals("back")) {
            if (deque.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(deque.peekLast()).append("\n");
            }
            
        }
    }
}
