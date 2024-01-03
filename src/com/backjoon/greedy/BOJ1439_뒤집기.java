package com.backjoon.greedy;

import java.util.*;

public class BOJ1439_뒤집기 {

    static int temp;
    static int zero;
    static int one;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        temp = input.charAt(0) - '0';
        zero = 0;
        one = 0;

        for (int i = 1; i < input.length(); i++) {
            int next = input.charAt(i) - '0';

            if (temp != next) {
                counting();
                temp = next;
            }
        }

        counting();

        System.out.println(Math.min(zero, one));
    }

    private static void counting() {
        if (temp == 0) zero++;
        else one++;
    }
}
