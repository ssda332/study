package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ17608_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int max = 0;
        int answer = 0;
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (max < pop) {
                answer++;
                max = pop;
            }
        }

        System.out.println(answer);
    }
}
