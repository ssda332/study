package com.backjoon.june;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beakjoon10828 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        int num = Integer.parseInt(number);


//        String[] commandArr = new String[num];
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            implStack(stack, br.readLine());
        }


    }

    public static void implStack(List<Integer> stack, String command) {
        if (command.contains("push")) {
            String[] s = command.split(" ");
            stack.add(Integer.parseInt(s[1]));
        }

        if (command.contains("pop")) {
            if (!stack.isEmpty()) {
                Integer remove = stack.remove(stack.size() - 1);
                System.out.println(remove);
            } else {
                System.out.println(-1);
            }

        }

        if (command.contains("size")) {
            System.out.println(stack.size());
        }

        if (command.contains("empty")) {
            boolean empty = stack.isEmpty();
            if (empty) {
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }

        if (command.contains("top")) {
            if (!stack.isEmpty()) {
                System.out.println(stack.get(stack.size() - 1));
            } else {
                System.out.println(-1);
            }

        }
    }
}
