package com.generic;

public class GenericMain {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("ok");
        System.out.println(box.get());

        Box<Integer> box1 = new Box<>();

        box1.set(1);
        System.out.println(box1.get());

    }
}
