package com.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {


        List<String> list = Arrays.asList("홍길동", "신용권", "자바", "김영진");
        /*for (String s : list) {
            System.out.println("s = " + s);
        }*/
        /*Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println("iterator = " + iterator.next());
        }*/

        Stream<String> stream = list.stream();
        stream.forEach(name -> System.out.println("name = " + name));

        list.stream()
                .forEach(s -> System.out.println("s = " + s));


    }

}
