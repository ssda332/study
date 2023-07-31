package com.backjoon.june;

import java.util.Scanner;

public class Beakjoon2231 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        boolean flag = false;

        for (int i = 1; i < 1000000; i++) {
            int sum = i;
            String stringSum = sum + "";

            for (int j = 0; j < stringSum.length(); j++) {
                sum += Integer.parseInt(stringSum.charAt(j) + "");
            }

            if (sum == num) {
                System.out.print(i);
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.print(0);
        }
    }
}
