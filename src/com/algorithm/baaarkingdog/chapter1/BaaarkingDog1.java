package com.algorithm.baaarkingdog.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BaaarkingDog1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        0x00 문제1.
        Integer num = Integer.parseInt(br.readLine());

        BigInteger result = func1(num);

        System.out.println(result);
*/
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = func2(arr, N);
        System.out.println(result);
    }

    private static BigInteger func1(int num) {
        BigInteger sum = new BigInteger("0");

        for (int i = 1; i < num; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum = sum.add(new BigInteger(i + ""));

            }
        }

        return sum;
    }

    private static int func2(int[] arr, int N) {

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] + arr[j] == 100) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
