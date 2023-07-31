package com.test;

public class test2 {

    public static void main(String[] args) {
        int answer = 1;

        while(true) {
            if(10 % (6 * answer) == 0) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }
}
