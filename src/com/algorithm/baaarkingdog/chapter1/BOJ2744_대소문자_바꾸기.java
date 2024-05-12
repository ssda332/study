package com.algorithm.baaarkingdog.chapter1;

import java.util.*;

public class BOJ2744_대소문자_바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 'a') {
                System.out.print((char)(s.charAt(i) + 32));
            } else {
                System.out.print((char)(s.charAt(i) - 32));
            }
        }
    }
}
