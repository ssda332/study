package com.backjoon.june;

import java.math.BigDecimal;
import java.util.Scanner;

public class Beakjoon2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] arr = line.split(" ");

        double conversion = conversion(arr[0], arr[1]);
        System.out.println(new BigDecimal(conversion).toPlainString());
    }

    public static double conversion(String num, String arithmetic) {
        double result = 0;

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) < 65) {
                result = result + (num.charAt(i) - 48) * Math.pow(Integer.parseInt(arithmetic), num.length() - i - 1);
            } else {
                result = result + (num.charAt(i) - 55) * Math.pow(Integer.parseInt(arithmetic), num.length() - i - 1);
            }
        }

        return result;
    }
}
