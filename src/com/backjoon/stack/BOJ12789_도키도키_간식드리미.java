package com.backjoon.stack;

import java.io.*;
import java.util.*;

public class BOJ12789_도키도키_간식드리미 {

    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        stack = new Stack<>();

        int count = 1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            stack.push(num);

            while (!stack.isEmpty()) {
                if (count == stack.peek()) {
                    stack.pop();
                    count++;
                } else {
                    break;
                }
            }
        }

        if (count == N + 1) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
