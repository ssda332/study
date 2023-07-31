package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1931_회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Schedule[] schedules = new Schedule[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            schedules[i] = new Schedule(start, end);
        }

        Arrays.sort(schedules);

        int count = 1;
        Schedule now = schedules[0];
        for (int i = 1; i < N; i++) {
            if (schedules[i].start >= now.end) {
                now = schedules[i];
                count++;
            }
        }

        System.out.println(count);

    }

    static class Schedule implements Comparable<Schedule> {
        public int start;
        public int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }
}
