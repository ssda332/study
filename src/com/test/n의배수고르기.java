package com.test;

import java.util.ArrayList;
import java.util.Arrays;

public class n의배수고르기 {

    public static void main(String[] args) {

        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = 3;

        ArrayList<Integer> list = new ArrayList<>();

        for(int el : numlist) {
            if(el % n == 0) {
                list.add(el);
            }
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));


    }
}
