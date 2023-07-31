package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Beakjoon11286_절댓값_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int o1abs = Math.abs(o1);
            int o2abs = Math.abs(o2);

            if (o1abs == o2abs) {
                return o1 - o2;
            } else {
                return o1abs - o2abs;
            }
        });

        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command != 0) {
                queue.add(command);
            }else {
                if (queue.isEmpty()) {
                    bf.append(0).append("\n");
                } else {
                    int poll = queue.poll();
                    bf.append(poll).append("\n");
                }
            }
        }

        System.out.println(bf);

    }
}
