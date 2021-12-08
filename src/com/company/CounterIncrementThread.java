package com.company;
import java.util.concurrent.locks.ReentrantLock;

public class CounterIncrementThread extends Thread {
    private Counter counter;
    private ReentrantLock locker;
    public CounterIncrementThread(Counter counter, ReentrantLock locker) {
        this.counter = counter;
        this.locker = locker;
    }
    @Override
    public void run() {
//        synchronized (counter) {
            for (int i = 0; i < 100000; i++) {
                try {
                    locker.lock();
                    counter.increment();
                } catch (InterruptedException e) { }
                finally {
                    locker.unlock();
                }
            }
//        }
    }
}