package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ17413_단어_뒤집기_2 {

    static StringBuilder sb;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        stack = new Stack<>();
        String str = br.readLine();

        boolean flag = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') {
                flag = true;
                flipStr();
                sb.append(c);
                continue;
            } else if (c == '>') {
                flag = false;
                sb.append(c);
                continue;
            }

            if (flag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    flipStr();
                    sb.append(" ");
                } else {
                    stack.push(c);
                }
            }
        }

        flipStr();
        System.out.println(sb);

    }

    private static void flipStr() {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
