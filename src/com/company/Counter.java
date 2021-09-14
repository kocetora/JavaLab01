package com.company;

public class Counter {
    private int counter;
    public int getCounter() {
        return counter;
    }
    public synchronized void increment() throws InterruptedException {
        counter++;
    }
    public synchronized void decrement() throws InterruptedException{
        counter--;
    }
}