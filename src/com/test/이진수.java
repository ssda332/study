package com.test;

import java.util.ArrayList;
import java.util.List;

public class 이진수 {
    public static void main(String[] args) {
        String bin1 = "10010";
        String bin2 = "1111";

        String answer = "";

        List<String> bl1 = new ArrayList<>();
        List<String> bl2 = new ArrayList<>();
        List<String> bl3 = new ArrayList<>();

        for(int i = bin1.length() - 1; i > 0; i--) {
            if(i == bin1.length() - 1) {
                bl1.add(bin1.substring(i));
            }else {
                bl1.add(bin1.substring(i-1, i));
            }
        }

        for(int i = bin2.length() - 1; i > 0; i--) {
            if(i == bin2.length() - 1) {
                bl2.add(bin2.substring(i));
            }else {
                bl2.add(bin2.substring(i-1, i));
            }
        }


    }
}
