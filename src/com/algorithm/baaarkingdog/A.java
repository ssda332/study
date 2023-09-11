package com.algorithm.baaarkingdog;

import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        if (N >= 1000) {
            if (U >= 8000 || L >= 260) {
                System.out.println("Very Good");
            } else {
                System.out.println("Good");
            }
        } else {
            System.out.println("Bad");
        }
    }
}
