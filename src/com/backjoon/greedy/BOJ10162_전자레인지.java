package com.backjoon.greedy;

import java.util.*;

public class BOJ10162_전자레인지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int A = 0;
        int B = 0;
        int C = 0;

        while (T >= 10) {
            if (T >= 300) {
                T -= 300;
                A++;
            } else if (T >= 60 && T < 300) {
                T -= 60;
                B++;
            } else {
                T -= 10;
                C++;
            }

        }

        if (T != 0) System.out.println(-1);
        else System.out.println(A + " " + B + " " + C);
    }


}
