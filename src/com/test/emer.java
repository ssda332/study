package com.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class emer {
    public static void main(String[] args) {
        int[] emergency = {1,2,3,4,5,6,7};
        int[] answer = emergency.clone();
        int[] des = new int[emergency.length];

        int[] answer2 = new int[emergency.length];;

        Arrays.sort(emergency);

        for(int i = 0; i < emergency.length; i++) {
            des[i] = emergency[emergency.length - i - 1];
        } // 내림차순 정렬

        System.out.println(Arrays.toString(des));
        System.out.println();
        System.out.println(Arrays.toString(answer));

        for(int i = 0; i < answer.length; i++) {
            for(int j = 0; j < des.length; j++) {
                if(answer[i] == des[j]) {

                    answer2[i] = j + 1;
                }
            }
        }

        Arrays.stream(answer2).forEach(a -> System.out.print(a + ","));

    }
}
