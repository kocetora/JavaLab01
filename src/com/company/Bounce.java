package com.company;

import javax.swing.*;

public class Bounce {
    public static void main(String[] args) {
        TestBilliard();
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
        CounterIncrementThread incrementThread =
            new CounterIncrementThread(counter);
        CounterDecrementThread decrementThread =
            new CounterDecrementThread(counter);
        incrementThread.start();
        decrementThread.start();
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) { }
        System.out.println("Result: " + counter.getCounter());
    }
}