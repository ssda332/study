package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1966_프린터_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Integer> iptQueue = new LinkedList<>();
            Queue<Integer> numQueue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int ipt = Integer.parseInt(st.nextToken());
                iptQueue.add(ipt);
                numQueue.add(i);
            }

            int idx = 1;

            while (!iptQueue.isEmpty()) {
                int iptPoll = iptQueue.poll();
                int numPoll = numQueue.poll();

                boolean flag = false;
                for (int j = iptPoll + 1; j <= 9; j++) {
                    if (iptQueue.contains(j)) {
                        flag = true;
                    }
                }

                if (flag) {
                    iptQueue.add(iptPoll);
                    numQueue.add(numPoll);
                } else {
                    if (M == numPoll) {
                        sb.append(idx).append("\n");

                    }

                    idx++;
                }

            }

        }

        System.out.println(sb);
    }

}
