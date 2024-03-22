package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ25314_코딩은_체육과목_입니다 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N != 0) {
            N -= 4;
            sb.append("long ");
        }

        sb.append("int");
        System.out.println(sb);
    }
}
