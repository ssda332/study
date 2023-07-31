package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int loop = 666;
        int check = 1;

        while (input != check) {
            loop++;
            if ((loop + "").contains("666")) check++;
        }

        System.out.println(loop);

    }
}
