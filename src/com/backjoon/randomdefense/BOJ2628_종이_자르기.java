package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2628_종이_자르기 {

    static ArrayList<Integer> xc = new ArrayList<>();
    static ArrayList<Integer> yc = new ArrayList<>();
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        xc.add(0);
        xc.add(x);
        yc.add(0);
        yc.add(y);

        int cut = Integer.parseInt(br.readLine());

        for (int i = 0; i < cut; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                xc.add(Integer.parseInt(st.nextToken()));
            } else {
                yc.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(xc);
        Collections.sort(yc);

        cut();
    }

    static void cut() {
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < xc.size() - 1; i++) {
            int distance = xc.get(i + 1) - xc.get(i);
            maxX = Math.max(distance, maxX);
        }

        for (int i = 0; i < yc.size() - 1; i++) {
            int distance = yc.get(i + 1) - yc.get(i);
            maxY = Math.max(distance, maxY);
        }

//        System.out.println("maxX : " + maxX + ", maxY : " + maxY);

        System.out.println(maxX * maxY);
    }
}
