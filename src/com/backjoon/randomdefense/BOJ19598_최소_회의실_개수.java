package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ19598_최소_회의실_개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> queue = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Meeting(start, true));
            queue.add(new Meeting(end, false));
        }

        int cnt = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Meeting poll = queue.poll();
            if (poll.isStart) {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt > max) max = cnt;
        }

        System.out.println(max);
    }

    static class Meeting implements Comparable<Meeting>{
        public int time;
        public boolean isStart;

        public Meeting(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Meeting o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
