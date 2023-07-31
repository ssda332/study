package com.backjoon.july;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class GcdExample1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
//        Deque<String> deque = new LinkedList<>();

        int N = sc.nextInt();

        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i * i != N) {
                    sb.append(i).append("\n");
//                    deque.addFirst(i + "\n");
                    sb.append(N / i).append("\n");
//                    deque.addLast(N / i + "\n");
                }else {
                    sb.append(i).append("\n");
                }
            }
        }
//        System.out.println(sb);
//        System.out.println(GCD(20, 12));
        System.out.println(GCD(20, 12));
    }

    public static int GCD(int a, int b) {
         if (b == 0) return a;
         return GCD(b, a % b);
    }


}
