package com.backjoon.stack;

import java.io.*;
import java.util.*;

public class BOJ2304_창고_다각형 {

    static Pillar pre;
    static int answer;

    static class Pillar implements Comparable<Pillar>{
        int p;
        int h;

        public Pillar(int p, int h) {
            this.p = p;
            this.h = h;
        }

        @Override
        public int compareTo(Pillar o) {
            return Integer.compare(this.p, o.p);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pillar> A = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            A.add(new Pillar(p, h));
        }

        Collections.sort(A);

        pre = A.get(0);
        answer = A.get(0).h;

        for (int i = 1; i < N; i++) {
            Pillar cur = A.get(i);
            if (cur.h >= pre.h) {
                addArea(cur);
            } else {
                boolean flag = true;

                for (int j = i + 1; j < N; j++) {
                    Pillar next = A.get(j);
                    if (cur.h < next.h) flag = false;
                }

                if (flag) {
                    addArea(cur);
                }
            }
        }

        System.out.println(answer);

    }

    static void addArea(Pillar cur) {
        if (cur.h >= pre.h) {
            int length = cur.p - pre.p - 1;
            answer += length * pre.h;
            answer += cur.h;
        } else {
            int length = cur.p - pre.p;
            answer += length * cur.h;
        }

        pre = cur;
    }
}
