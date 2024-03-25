package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class 연습장 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        System.out.println(N * M);

    }
    
}
