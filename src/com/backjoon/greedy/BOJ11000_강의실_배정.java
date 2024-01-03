package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ11000_강의실_배정 {

    static class Schedule implements Comparable<Schedule>{
        int start;
        int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            if (Integer.compare(this.start, o.start) == 0) Integer.compare(this.end, o.end);
            return Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Schedule[] list = new Schedule[N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[i] = new Schedule(start, end);
        }

        Arrays.sort(list);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(list[0].end);
        int answer = 1;


        for (int i = 1; i < N; i++) {
            int peek = queue.peek();
            Schedule s = list[i];

            if (s.start < peek) {
                answer++;
            } else {
                queue.poll();
            }
            queue.add(s.end);
        }

        System.out.println(answer);
    }
}
