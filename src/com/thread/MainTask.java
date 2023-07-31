package com.thread;

import java.awt.*;

public class MainTask {

    public static void main(String[] args) {
//
//        Runnable task = new Task();
//        Thread thread = new Thread(task);
//

        /*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("익명 클래스로 Runnable 객체 구현");

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("람다식으로 Runnable 객체 구현");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
        thread2.start();

        */
        Thread thread = new Thread(() -> {

            Thread.currentThread().setName("thread-12");


            for (int i = 0; i < 5; i++) {
                System.out.println("람다로 Thread 객체 구현");
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        System.out.println(thread.getName());



        thread.start();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }
}
