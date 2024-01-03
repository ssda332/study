package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            Stack<String> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < str.length(); i++) {
                String piece = str.substring(i, i + 1);

                if (piece.equals("(")) {
                    stack.push(piece);
                } else {
                    if (!stack.isEmpty()) stack.pop();
                    else flag = false;
                }

            }

            if (!stack.isEmpty()) flag = false;
            if (flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

        }

        System.out.println(sb);
    }
}
