package com.backjoon.randomdefense;

import java.util.*;

public class BOJ9659_돌_게임_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        if (N % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
