package com.backjoon.twopointer;

import java.util.Scanner;

public class BOJ2018_수들의_합_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N + 1];

        int start = 1;
        int end = 1;
        int sum = 1;
        int cnt = 1;

        while (end != N) {
            if (sum == N) {
                cnt++;
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }

        System.out.println(cnt);
    }
}
