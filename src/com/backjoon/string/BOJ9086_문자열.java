package com.backjoon.string;

import java.util.*;

public class BOJ9086_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String str = sc.nextLine();
            sb.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
        }

        System.out.println(sb);
    }
}
