package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12891_DNA_비밀번호 {

    static int checkSecret = 0;
    static int[] sACGT = new int[4];
    static int[] pACGT = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sLength = Integer.parseInt(st.nextToken());
        int pLength = Integer.parseInt(st.nextToken());
        int count = 0;

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            sACGT[i] = Integer.parseInt(st.nextToken());
            if (sACGT[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < pLength; i++) {
            add(dna.charAt(i));
        }

        if (checkSecret == 4) {
            count++;
        }

        int start_idx = pLength;
        int end_idx = sLength;
        int remove_idx = 0;

        for (int i = start_idx; i < sLength; i++) {
            add(dna.charAt(i));
            remove(dna.charAt(remove_idx));
            remove_idx++;
            if (checkSecret == 4) {
                count++;
            }
        }

        System.out.println(count);
        br.close();

    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                pACGT[0]++;
                if (sACGT[0] == pACGT[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                pACGT[1]++;
                if (sACGT[1] == pACGT[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                pACGT[2]++;
                if (sACGT[2] == pACGT[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                pACGT[3]++;
                if (sACGT[3] == pACGT[3]) {
                    checkSecret++;
                }
                break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (sACGT[0] == pACGT[0]) {
                    checkSecret--;
                }
                pACGT[0]--;
                break;
            case 'C':
                if (sACGT[1] == pACGT[1]) {
                    checkSecret--;
                }
                pACGT[1]--;
                break;
            case 'G':
                if (sACGT[2] == pACGT[2]) {
                    checkSecret--;
                }
                pACGT[2]--;
                break;
            case 'T':
                if (sACGT[3] == pACGT[3]) {
                    checkSecret--;
                }
                pACGT[3]--;
                break;
        }
    }
}
