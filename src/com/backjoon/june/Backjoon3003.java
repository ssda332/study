package com.backjoon.june;

import java.util.Scanner;

public class Backjoon3003 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer[] chess = {1, 1, 2, 2, 2, 8};

        String input = sc.nextLine();

        String[] arr = input.split(" ");

        for(int i = 0; i < chess.length; i++) {
            chess[i] = chess[i] - Integer.parseInt(arr[i]);
            if (i != chess.length - 1) {
                System.out.print(chess[i] + " ");
            } else {
                System.out.print(chess[i]);
            }
        }



    }
}
