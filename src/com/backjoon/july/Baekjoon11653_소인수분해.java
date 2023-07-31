package com.backjoon.july;

import java.util.Scanner;

public class Baekjoon11653_소인수분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                sb.append(i).append("\n");
                N = N / i;
            }

        }
        if (N != 1) {
            sb.append(N).append("\n");
        }
        System.out.println(sb);


    }
}
