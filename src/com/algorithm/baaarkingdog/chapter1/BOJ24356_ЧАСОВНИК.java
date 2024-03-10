package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ24356_ЧАСОВНИК {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int tm1 = Integer.parseInt(t1 + "" + m1);
        int tm2 = Integer.parseInt(t2 + "" + m2);

        int answer1 = 0;
        int answer2 = 0;

        if (tm1 > tm2) {
            int i = ((24 - t1) * 60) - m1;
            int j = (t2 * 60) + m2;

            answer1 = i + j;
            answer2 = answer1 / 30;
        } else if (tm1 < tm2) {
            // 13 40 15 10  2 -20    13 20  15 40
            int i = (t2 - t1) * 60;
            int j = m2 - m1;

            answer1 = i + j;
            answer2 = answer1 / 30;
        }

        ArrayList<String> list = new ArrayList<>();
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        System.out.println(answer1 + " " + answer2);
    }
}
