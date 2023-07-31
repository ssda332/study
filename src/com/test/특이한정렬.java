package com.test;

import java.util.*;

public class 특이한정렬 {
    public static void main(String[] args) {
        Integer[] numlist = {600, 400, 300, 200, 700, 800, 100, 900};
        int n = 500;


        Arrays.sort(numlist, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Abs = Math.abs(o1 - n);
                int o2Abs = Math.abs(o2 - n);
                System.out.println(o1);
                System.out.println(o2);
                if(o1Abs == o2Abs) {
                    if (o1 > o2) return -1;
                    else if (o1 < o2) return 1;
                } else {
                    return o1Abs - o2Abs;
                }

                return 0;
            }
        });

        System.out.println(Arrays.toString(numlist));
    }
}
