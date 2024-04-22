package com.backjoon.dp;

import java.util.*;

public class BOJ9655_돌_게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N % 2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }
}
