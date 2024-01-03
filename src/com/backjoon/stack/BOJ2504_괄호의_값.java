package com.backjoon.stack;

import java.io.*;
import java.util.*;

public class BOJ2504_괄호의_값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int temp = 1;
        int sum = 0;
        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                temp *= 2;
                stack.push(c);
            } else if (c == '[') {
                temp *= 3;
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }

                char peek = stack.peek();

                if (c == ')') {
                    if (stack.isEmpty() || peek != '(') flag = false;

                    if (str.charAt(i - 1) == '(') {
                        sum += temp;
                    }
                    stack.pop();
                    temp /= 2;
                } else if (c == ']') {
                    if (stack.isEmpty() || peek != '[') flag = false;

                    if (str.charAt(i - 1) == '[') {
                        sum += temp;
                    }
                    stack.pop();
                    temp /= 3;
                }

            }

        }

        if (flag && stack.isEmpty()) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }


    }
}
