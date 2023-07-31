package com.algorithm.baaarkingdog.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int result = func3(num);
        System.out.println(result);
    }

    private static int func3(int num) {
        double sqrt = Math.sqrt(num);
        int sqrtInt = (int) sqrt;
        if (sqrt == sqrtInt) return 1;
        return 0;
    }
}
