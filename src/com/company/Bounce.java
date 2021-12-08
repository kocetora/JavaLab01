package com.company;
import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

public class Bounce {
    public static void main(String[] args) {
//        TestBilliard();
        TestCounter();
    }

    public static void TestBilliard() {
        BounceFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        System.out.println("Thread name = " +
                Thread.currentThread().getName());
    }

    public static void TestCounter() {
        Counter counter = new Counter();
        ReentrantLock locker = new ReentrantLock();
        CounterIncrementThread incrementThread =
            new CounterIncrementThread(counter, locker);
        CounterDecrementThread decrementThread =
            new CounterDecrementThread(counter, locker);
        incrementThread.start();
        decrementThread.start();
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) { }
        System.out.println("Result: " + counter.getCounter());
    }
}