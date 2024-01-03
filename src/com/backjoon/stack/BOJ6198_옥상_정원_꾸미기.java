package com.backjoon.stack;

import java.io.*;
import java.util.*;

public class BOJ6198_옥상_정원_꾸미기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static void main(String[] args) throws IOException {

        int N = getNumber();
        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        // 이전 옥상 높이 체크
        // 현재 옥상보다 낮거나 같으면 pop
        //

        for (int i = 0; i < N; i++) {
            int curHeight = getNumber();

            while (true) {
                if (stack.isEmpty()) {
                    stack.push(curHeight);
                    break;
                } else {
                    int preHeight = stack.peek();

                    if (preHeight <= curHeight) {
                        stack.pop();
                    } else {
                        sum += stack.size();
                        stack.push(curHeight);
                        break;
                    }
                }
            }

        }

        System.out.println(sum);

    }

    private static Integer getNumber() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
