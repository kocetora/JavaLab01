package com.company;

public class Counter {
    private int counter;
    public int getCounter() {
        return counter;
    }
//    public synchronized void increment() throws InterruptedException {
//        counter++;
//    }
//    public synchronized void decrement() throws InterruptedException {
//        counter--;
//    }

    public void increment() throws InterruptedException {
        counter++;
    }
    public void decrement() throws InterruptedException {
        counter--;
    }

//    boolean isBusy = false;
//    public synchronized void increment() throws InterruptedException {
//        if(isBusy){
//            wait();
//        }
//        isBusy = true;
//        counter++;
//        notifyAll();
//    }
//    public synchronized void decrement() throws InterruptedException {
//        if(isBusy){
//            wait();
//        }
//        isBusy = true;
//        counter--;
//        notifyAll();
//    }
}