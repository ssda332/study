package com.backjoon.stack;

import java.io.*;
import java.util.*;

public class BOJ3986_좋은_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Stack<String> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                String sub = s.substring(j, j + 1);
                if (stack.isEmpty()) {
                    stack.push(sub);
                } else {
                    String peek = stack.peek();
                    if (peek.equals(sub)) {
                        stack.pop();
                    } else {
                        stack.push(sub);
                    }
                }
            }

            if (stack.isEmpty()) answer++;

        }

        System.out.println(answer);

    }
}
