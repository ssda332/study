package com.backjoon.randomdefense;

import java.io.*;

public class BOJ1564_팩토리얼5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Integer.parseInt(br.readLine());
        long num = 1;
        long k = (long)1e12;

        for(long i=1; i<=n; i++) {
            num *=i;
            while(num%10==0)
                num/=10;
            num%=k;
        }

        num %= 100000;
        if(num<10000) sb.append(0);
        if(num<1000) sb.append(0);
        if(num<100) sb.append(0);
        if(num<10) sb.append(0);
        sb.append(num);
        System.out.print(sb);
    }
}
