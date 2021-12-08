package com.company;

public class CounterIncrementThread extends Thread {
    private Counter counter;
    public CounterIncrementThread(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i < 100000; i++) {
                try {
                    counter.increment();
                } catch (InterruptedException e) { }
            }
        }
    }
}