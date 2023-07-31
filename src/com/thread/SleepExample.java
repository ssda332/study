package com.thread;

import java.awt.*;

public class SleepExample {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 10; i++) {
            toolkit.beep();
            try {
                Thread.sleep(1000);
                Thread.State state = Thread.currentThread().getState();
                System.out.println("메인스레드 상태 : " + state);
            } catch (InterruptedException e) {

            }
        }
    }
}
