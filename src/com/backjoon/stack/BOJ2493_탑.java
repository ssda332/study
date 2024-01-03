package com.backjoon.stack;

import java.io.*;
import java.util.*;

public class BOJ2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());

            while (true) {
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                    stack.push(new Top(top, i));
                    break;

                } else {
                    Top peek = stack.peek();
                    if (peek.height >= top) {
                        sb.append(peek.num).append(" ");
                        stack.push(new Top(top, i));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb);

    }

    static class Top {
        public int height;
        public int num;

        public Top(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }
}
