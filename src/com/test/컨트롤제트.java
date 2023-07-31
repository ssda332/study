package com.test;

import java.util.Arrays;

public class 컨트롤제트 {

    public static void main(String[] args) {

        int java = Math.abs(-1);
        System.out.println(java);
        StringBuilder sb = new StringBuilder();

        String s = "1 2 Z 3";
        int answer = 0;

        String[] arr = s.split(" ");

        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("Z")) {
                answer -= Integer.parseInt(arr[i - 1]);
            }else {
                answer += Integer.parseInt(arr[i]);
            }

        }

        System.out.println(answer);

    }
}
