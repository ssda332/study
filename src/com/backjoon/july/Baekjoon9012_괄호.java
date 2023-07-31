package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            boolean flag = true;

            for (int j = 0; j < input.length(); j++) {
                char ps = input.charAt(j);

                if (ps == '(') {
                    stack.push(1);
                } else if (!stack.isEmpty() && ps == ')') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }

            }

            if (!stack.empty()) {
                flag = false;
            }

            if (flag) {
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
            }
            stack.clear();
        }

        System.out.println(sb);
    }
}
