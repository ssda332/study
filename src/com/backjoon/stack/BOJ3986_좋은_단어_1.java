package com.backjoon.stack;

import java.io.*;
import java.util.*;

public class BOJ3986_좋은_단어_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) stack.push(c);
                else {
                    char peek = stack.peek();
                    if (c == peek) stack.pop();
                    else stack.push(c);
                }
            }

            if (stack.isEmpty()) answer++;
        }

        System.out.println(answer);
    }
}
