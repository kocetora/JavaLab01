package com.company;
import java.util.concurrent.locks.ReentrantLock;

public class CounterDecrementThread extends Thread {
    private Counter counter;
    private ReentrantLock locker;
    public CounterDecrementThread(Counter counter, ReentrantLock locker) {
        this.counter = counter;
        this.locker = locker;
    }
    @Override
    public void run() {
//        synchronized (counter) {
            for (int i = 0; i < 100000; i++) {
//                locker.lock();
                try {
                    counter.decrement();
                } catch (InterruptedException e) { }
//                finally {
//                    locker.unlock();
//                }
            }
//        }
    }
}
