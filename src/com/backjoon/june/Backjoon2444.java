package com.backjoon.june;

import java.util.Scanner;

public class Backjoon2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        star(sc.nextInt());
    }

    public static void star(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 1; i <= num - 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (2 * num - 1) - (2 * i); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
