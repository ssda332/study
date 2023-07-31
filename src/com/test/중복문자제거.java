package com.test;

import java.util.stream.Collectors;

public class 중복문자제거 {

    public static void main(String[] args) {
        /*
        String[] arr = new String[my_string.length()];

        for(int i = 0; i < my_string.length(); i++) {
            arr[i] = Character.toString(my_string.charAt(i));
        }

        List<String> list = Arrays.asList(arr)
                .stream()
                .distinct()
                .collect(Collectors.toList());

        for(int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        */


        /*
        int answer = -1;
        int length = 101;

        for(int i = 0; i < array.length; i++) {
            if(array[i] < n && length > n - array[i]) {
                length = n - array[i];
                answer = array[i];
            }else if(array[i] > n && length > array[i] - n) {
                length = array[i] - n;
                answer = array[i];
            }else if(length == n - array[i] || length == array[i] - n) {
                if(array[i] < answer) {
                    answer = array[i];
                }
            }
        }

        return answer;


         */
    }
}
