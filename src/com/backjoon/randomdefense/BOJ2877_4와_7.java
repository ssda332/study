package com.backjoon.randomdefense;

import java.util.*;

public class BOJ2877_4와_7 {

    static int K;
    static int cnt = 0;

    public static void main(String[] args) {
        // 0914
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt(); // 1,000,000,000

        // 00 01 10
        // 01 10 11
//        bfs("4");
        int cnt = 0;
        String num = "";

    }

    static void bfs(String n) {
        Queue<String> queue = new LinkedList<>();
        queue.add(n);
        if (n.equals("4")) queue.add("7");

        while(!queue.isEmpty()) {
            String poll = queue.poll();
            cnt++;

            if (K == cnt) {
                System.out.println(poll);
                return;
            }

            queue.add(poll + "4");
            queue.add(poll + "7");
        }

    }
}
