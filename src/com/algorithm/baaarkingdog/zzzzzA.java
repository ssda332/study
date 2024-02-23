package com.algorithm.baaarkingdog;

import java.util.*;
import java.io.*;

public class zzzzzA {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] A = {25, 10, 5, 1};
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int C = Integer.parseInt(br.readLine());

            for (int i = 0; i < 4; i++) {
                int num = C / A[i];
                sb.append(num).append(" ");
                C %= A[i];
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }
}
