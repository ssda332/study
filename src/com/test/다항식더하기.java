package com.test;

public class 다항식더하기 {
    public static void main(String[] args) {
        String polynomial = "3x + 7 + x";
        String answer = "";

        int xsum = 0;
        int sum = 0;

        String[] arr = polynomial.split(" ");

        for(String el : arr) {
            if(el.matches(".*[a-zA-Z].*")) {
                el = el.replace("x", "");
                if(el.equals("")) el = "1";
                System.out.println(el);
                xsum += Integer.parseInt(el);
            }else {
                if(el.contains("+")) continue;
                sum += Integer.parseInt(el);
            }
        }
    }
}
