package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ1972_놀라운_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("*")) break;
            int length = str.length();
            boolean isSurprising = true;

            for (int i = 0; i <= length - 2; i++) {
                // i-쌍
                HashSet<String> set = new HashSet<>();
                for (int j = 0; j < length - i - 1; j++) {
                    String couple = "" + str.charAt(j) + str.charAt(j + i + 1);
                    set.add(couple);
                }

                if (set.size() != length - i - 1) isSurprising = false;
            }

            if (isSurprising) {
                sb.append(str).append(" is surprising.\n");
            } else {
                sb.append(str).append(" is NOT surprising.\n");
            }

        }

        System.out.println(sb);
    }
}
