package com.company;

public class BallThreadJoin extends BallThread{
    private Thread threadToWait;

    public BallThreadJoin(Ball ball, Thread threadForWaiting) {
        super(ball);
        this.threadToWait = threadForWaiting;
    }

    @Override
    public void run() {
        try {
            threadToWait.join();
            for (int i = 1; i < 10000; i++) {
                if (getBall().move()) {
                    break;
                }
                System.out.println("Thread name = " + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
        }
    }
}
