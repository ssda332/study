package com.algorithm.baaarkingdog.chapter1;

import java.io.*;

public class TEST3 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'|| str.charAt(i) == 'o' || str.charAt(i) == 'u') answer++;
        }

        System.out.println(answer);
    }
}