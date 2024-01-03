package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ9935_문자열_폭발 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String bomb = br.readLine();


        Stack<Character> stack = new Stack<>();
        int size = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            char piece = str.charAt(i);
            stack.push(piece);

            if (stack.size() >= size) {
                boolean flag = true;

                for (int j = 0; j < size; j++) {
                    if (stack.get(stack.size() - size + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < size; j++) {
                        stack.pop();
                    }
                }

            }
        }

        /*while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }*/
        for(Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
