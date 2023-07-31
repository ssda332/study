package com.thread;

public class CalcThread extends Thread{
    public CalcThread(String name) {
        setName(name);
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {//시간을 지연시키기 위함
            int x = 100; x += i;
            for (int j = 0; j < 10000; j++) {
                x += j;
            }
        }
        System.out.println(getName());
    }
}
