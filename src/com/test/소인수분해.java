package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소인수분해 {

    public static void main(String[] args) {

        Integer[] answer2 = {};
        List list = new ArrayList();

        int n = 420;

        for(int i = 2; i <= n; i++) {
            if(n % i == 0) {
                list.add(i);
                n /= i;
                i = 1;
            }
        }



        answer2 = (Integer[]) list.toArray(answer2);

        Arrays.sort(answer2);
        answer2 = Arrays.stream(answer2).distinct().toArray(Integer[]::new);
        int[] answer = Arrays.stream(answer2).mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(answer));
    }


}
