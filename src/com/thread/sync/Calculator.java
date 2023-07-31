package com.thread.sync;

public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        synchronized (this) {
            this.memory = memory;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }


    }
}

