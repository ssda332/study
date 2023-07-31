package com.backjoon.june;

import java.util.Scanner;

public class Backjoon2941 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        int result = 0;
        String[] croAlpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < croAlpha.length; i++) {
            word = word.replace(croAlpha[i], "?");
        }

        System.out.println(word.length());

    }
}
