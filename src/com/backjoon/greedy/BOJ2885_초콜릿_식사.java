package com.backjoon.greedy;

import java.util.*;

public class BOJ2885_초콜릿_식사 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int K = sc.nextInt();
        int size = 1;
        while (size < K) {
            size *= 2;
        }

        sb.append(size).append(" ");
        int answer = 0;

        while (K > 0) {
            if (K >= size) {
                K -= size;
            } else {
                size /= 2;
                answer++;
            }
        }

        sb.append(answer);
        System.out.println(sb);

    }

}
