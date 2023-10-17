package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String problem = br.readLine();

            if (problem.equals("0")) {
                break;
            }

            int size = problem.length();
            boolean flag = true;

            for (int i = 0; i < size / 2; i++) {
                if (problem.charAt(i) != problem.charAt(size - i - 1)) {
                    sb.append("no\n");
                    flag = false;
                    break;
                }
            }

            if (flag) sb.append("yes\n");
        }

        System.out.println(sb);
    }
}
