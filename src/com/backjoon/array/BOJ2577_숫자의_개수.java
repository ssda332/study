package com.backjoon.array;

import java.io.*;
import java.util.*;

public class BOJ2577_숫자의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int prod = A * B * C;
        int[] arr = new int[10];

        while (prod / 10 != 0) {
            int n = prod % 10;
            arr[n]++;

            prod /= 10;
        }

        arr[prod]++;

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }

    }
}
