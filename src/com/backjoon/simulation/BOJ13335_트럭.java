package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ13335_트럭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        // queue에 0으로 w만큼 채움
        // if (다음 인덱스의 트럭 무게를 더한 현재하중이 다리 최대하중보다 낮거나 같으면)
        // 큐 pop -> 트럭 합류
        // else 큐 pop -> 0 합류

        int idx = 0;
        int time = 0;
        int sum = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < w; i++) {
            queue.add(0);
        }

        while (idx < n) {
            int poll = queue.poll();
            sum -= poll;
            queue.add(0);

            if (sum + trucks[idx] <= L) {
                queue.removeLast();
                queue.addLast(trucks[idx]);

                sum += trucks[idx];
                idx++;
            }

            time++;
        }

        while (!queue.isEmpty()) {
            queue.poll();
            time++;
        }

        System.out.println(time);

    }

}
