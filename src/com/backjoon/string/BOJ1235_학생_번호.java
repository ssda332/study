package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ1235_학생_번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        String[] S = new String[N];
        for(int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }
        int length = S[0].length();

        for(int k = 1; k <= length; k++){
            for(int i=0;i<N;i++){
                set.add(S[i].substring(length - k));
            }
            if(set.size() == N){
                System.out.println(k);
                return;
            }
            set.clear();
        }
    }
}
