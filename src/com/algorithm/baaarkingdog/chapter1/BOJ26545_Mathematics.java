package com.algorithm.baaarkingdog.chapter1;

import java.io.*;

public class BOJ26545_Mathematics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += Integer.parseInt(br.readLine());
        }

        System.out.println(answer);
    }
}
