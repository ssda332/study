package com.backjoon.july;

import java.io.*;
import java.util.Stack;

public class Baekjoon4949_균형잡힌_세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        while (true) {
            stack.clear();
            String line = br.readLine();
            if (line.equals(".")) break;
            // ( [ ]
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(') {
                    stack.push(1);
                } else if (line.charAt(i) == '[') {
                    stack.push(2);
                } else if (line.charAt(i) == ')') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == 1) {
                            stack.pop();
                        }else {
                            stack.push(3);
                            break;
                        }
                    } else {
                        stack.push(3);
                        break;
                    }
                } else if (line.charAt(i) == ']') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == 2) {
                            stack.pop();
                        }else {
                            stack.push(3);
                            break;
                        }
                    } else {
                        stack.push(3);
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
