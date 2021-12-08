package com.company;

public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball){
        b = ball;
    }
    public Ball getBall() {
        return b;
    }
    @Override
    public void run(){
        try{
            while (!b.isInPocket) {
                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        } catch(InterruptedException ex){

        }
    }
}
