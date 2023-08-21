package com.backjoon.randomdefense;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1094_막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int sum = 64;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(sum);

        while (sum > X) {
            int poll = queue.poll();
            int big = 0;
            int small = 0;

            if (poll % 2 == 0) {
                big = poll / 2;
                small = poll / 2;
            } else {
                big = poll / 2 + 1;
                small = poll / 2;
            }

//            System.out.println("poll : " + poll + ", big : " + big + ", small : " + small + ", sum : " + sum);

            if (sum - big >= X) {
                queue.add(small);
                sum -= big;
            }else if (sum - small >= X) {
                queue.add(big);
                sum -= small;
            }else {
                queue.add(big);
                queue.add(small);
            }

        }

        System.out.println(queue.size());




    }
}
