package com.backjoon.randomdefense;

import java.util.*;

public class BOJ2877_4와_7_RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        String binaryString = Integer.toBinaryString(K + 1).replace("0", "4").replace("1", "7");

        String answer = "";
        for (int i = 1; i < binaryString.length(); i++) {
            answer += binaryString.substring(i, i + 1);
        }

        System.out.println(answer);
    }
}
// 1 10 11 100