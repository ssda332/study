package com.backjoon.string;

import java.util.*;

public class BOJ12904_A와_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();

        StringBuilder sb = new StringBuilder(T);
        for (int i = T.length() - 1; i >= 0; i--) {
            if (S.equals(sb.toString())) {
                System.out.println(1);
                return;
            }

            if (sb.substring(i, i + 1).equals("A")) {
                sb.delete(i, i + 1);
            } else if (sb.substring(i, i + 1).equals("B")){
                sb.delete(i, i + 1).reverse();
            } else {
                break;
            }
        }

        System.out.println(0);
    }
}
