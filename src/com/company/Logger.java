package com.company;

public class Logger {
    private boolean isBusy = true;

    public synchronized void logColumn() throws InterruptedException {
//        if (isBusy) {
//            wait();
//        }
        System.out.println("|");
//        isBusy = true;
//        notifyAll();
    }

    public synchronized void logLine() throws InterruptedException {
//        if (!isBusy) {
//            wait();
//        }
        System.out.println("-");
//        isBusy = false;
//        notifyAll();
    }
}
