package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2884_알람_시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M < 45) {
            if (H == 0) H = 23;
            else H--;
            M += 15;
        } else {
            M -= 45;
        }

        System.out.println(H + " " + M);
    }
}
