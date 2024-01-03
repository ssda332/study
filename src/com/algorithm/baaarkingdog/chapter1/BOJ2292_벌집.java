package com.algorithm.baaarkingdog.chapter1;

import java.util.*;

public class BOJ2292_벌집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 1) {
            System.out.println(1);
            return;
        }
        if (N <= 7) {
            System.out.println(2);
            return;
        }

        int count = 3;
        int pre = 12;
        int start = 8;

        for (int i = 8; i <= N; i++) {
            if (i == pre + start) {
                count++;
                pre += 6;
                start = i;
            }
        }

        System.out.println(count);

    }
}
