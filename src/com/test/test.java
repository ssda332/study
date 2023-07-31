package com.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 3, 3, 4};
        int max = Integer.MIN_VALUE;
        int answer = 0;

        Arrays.sort(array);

        int index[] = new int[1000];

        for (int i = 0; i < array.length; i++) {
            index[array[i]]++;
        }

        System.out.println(Arrays.toString(index));

        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0 & index[i] >= max) {
                if (index[i] == max) {
                    answer = -1;
                } else {
                    max = index[i];
                    answer = i;
                }
            }

            //if(max != 0 && index[i] == max) answer = -1;

        }

        System.out.println(answer);
    }
}
