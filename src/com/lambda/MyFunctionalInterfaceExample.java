package com.lambda;

import java.util.function.*;

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface my;
/*
        my = () -> {
            System.out.println("안녕");
        };

        my.method();*/
/*
        my = (x) -> System.out.println("result = " + x);

        my.method(5);*/

        Consumer c = (x) -> System.out.println(x);

        c.accept(5);

        BiConsumer<Integer, Integer> bi = (x, y) ->  {
            int result = x + y;
            System.out.println("result = " + result);
        };
        bi.accept(5, 10);

        DoubleConsumer db = y -> System.out.println("java" + y);
        db.accept(8.0);

        Supplier<String> sup = () -> "안녕";
        System.out.println(sup.get());

        IntSupplier supInt = () -> 1;
        System.out.println("supInt = " + supInt.getAsInt());

        Function<String, String> fun = (x) -> x + "님, 안녕하세요";
        System.out.println(fun.apply("김영진"));

    }
}
