package com.backjoon.randomdefense;

import java.util.*;

public class BOJ1676_팩토리얼_0의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = 0;
        int b = 0;

        for (int i = 2; i <= N; i++) {
            int num = i;
            while (num % 2 == 0) {
                num /= 2;
                a++;
            }

            while (num % 5 == 0) {
                num /= 5;
                b++;
            }
        }

        System.out.println(Math.min(a, b));
    }
}
