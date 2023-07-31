package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1874_스택_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        int cnt = 1;
        boolean flag = true;

        for (int i = 1; i <= n; i++) {
            if (cnt <= arr[i]) {
                while (cnt <= arr[i]) {
                    stack.push(cnt);
                    sb.append("+").append("\n");
                    cnt++;
                }

                stack.pop();
                sb.append("-\n");
            } else {
                int pop = stack.pop();

                if (pop > arr[i]) {
                    System.out.println("NO");
                    flag = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (flag) System.out.println(sb);


/*        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= num) {
                while (A[i] >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");

            } else {
                int pop = stack.pop();
                if (pop > A[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                }else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf);*/
    }
}
