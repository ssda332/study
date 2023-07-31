package com.thread;

public class Task implements Runnable{

    public Task() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable 구현 객체로 작업 스레드 생성");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }

    }
}
