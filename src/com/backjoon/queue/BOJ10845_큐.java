package com.backjoon.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Integer last = -1;

        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");

            if (st.length > 1) {
                int n = Integer.parseInt(st[1]);
                last = n;
                queue.add(n);
            } else {
                if (st[0].equals("pop")) {
                    Integer poll = queue.poll();
                    if (poll == null) {
                        bw.write(-1 + "\n");
                    } else {
                        if (queue.isEmpty()) last = -1;
                        bw.write(poll + "\n");
                    }
                } else if (st[0].equals("size")) {
                    bw.write(queue.size() + "\n");
                } else if (st[0].equals("empty")) {
                    int result = 0;
                    if (queue.isEmpty()) result = 1;
                    bw.write(result + "\n");
                } else if (st[0].equals("front")) {
                    Integer peek = queue.peek();
                    if (peek == null) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(peek + "\n");
                    }
                } else if (st[0].equals("back")) {
                    if (last == null) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(last + "\n");
                    }

                }
            }
        }

        bw.flush();
        bw.close();
    }
}
