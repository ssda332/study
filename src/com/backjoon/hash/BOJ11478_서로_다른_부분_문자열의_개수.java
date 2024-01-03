package com.backjoon.hash;

import java.util.*;

public class BOJ11478_서로_다른_부분_문자열의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j < S.length(); j++) {
                set.add(S.substring(i, j+1));
            }
        }

        System.out.println(set.size());

    }
}
