package com.backjoon;

import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = br.readLine().split(" ");

        double sum = Arrays.stream(A)
                .mapToDouble(s -> {
                    return Math.pow(Double.parseDouble(s), 2) % 10;
                })
                .sum();

        System.out.println((int)(sum % 10));
    }
}
