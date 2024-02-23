package com.algorithm.baaarkingdog.chapter1;

import java.util.*;

public class BOJ2739_구구단 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        for (int i = 1; i <= 9; i++) {
            sb.append(N).append(" * ").append(i).append(" = ").append(N * i).append("\n");
        }

        System.out.println(sb);
    }
}
