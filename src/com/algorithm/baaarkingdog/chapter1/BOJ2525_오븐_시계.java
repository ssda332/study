package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ2525_오븐_시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        M = M + C;

        while (M >= 60) {
            H += 1;
            M -= 60;
        }

        while (H >= 24) {
            H -= 24;
        }

        System.out.println(H + " " + M);
    }
}
