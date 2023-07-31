package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuffer bf = new StringBuffer();
        stack.push(0);

        for (int i = 1; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int pop = stack.pop();
                result[pop] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
