package com.generic;

public class BoxingMethodExample {
    public static void main(String[] args) {
        Util util = new Util();
        Box<String> box1 = util.boxing("ok");
        Box<Integer> box2 = util.boxing(100);

    }
}
