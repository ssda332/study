package com.algorithm.baaarkingdog;

import java.util.*;
import java.io.*;

public class zzzzzA {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        if (p <= 50 && q <= 10) {
            System.out.println("White");
        } else if (q >= 30) {
            System.out.println("Red");
        } else {
            System.out.println("Yellow");
        }


    }
}
