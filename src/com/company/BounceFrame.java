package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonBlue = new JButton("Add blue");
        JButton buttonRed = new JButton("Add red");
        JButton buttonJoin = new JButton("Join");
        JButton buttonStop = new JButton("Stop");
        JLabel resultLabel = new JLabel("Result: " + BallCanvas.ballCounter);

        buttonBlue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 1000; i++) {
                    Ball b = new Ball(canvas, resultLabel, Color.CYAN, true);
                    canvas.add(b);

                    BallThread thread = new BallThread(b);
                    thread.setPriority(Thread.MIN_PRIORITY);
                    thread.setName("Blue " + thread.getName());
                    thread.start();
                    System.out.println("Thread name = " +
                            thread.getName());
                }
            }
        });
        buttonRed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Ball b = new Ball(canvas, resultLabel, Color.MAGENTA, true);
                canvas.add(b);

                BallThread thread = new BallThread(b);
                thread.setPriority(thread.MAX_PRIORITY);
                thread.setName("Red " + thread.getName());
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });
        buttonJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ball b1 = new Ball(canvas, resultLabel, Color.RED, false);
                canvas.add(b1);

                BallThread threadToWait = new BallThread(b1);
                threadToWait.setName("Red " + threadToWait.getName());
                threadToWait.start();
                System.out.println("Thread name = " + threadToWait.getName());

                Ball b2 = new Ball(canvas, resultLabel, Color.BLUE, false);
                canvas.add(b2);

                BallThreadJoin thread = new BallThreadJoin(b2, threadToWait);
                thread.setName("Blue " + thread.getName());
                thread.start();
                System.out.println("Thread name = " + thread.getName());
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(buttonBlue);
        buttonPanel.add(buttonRed);
        buttonPanel.add(buttonJoin);
        buttonPanel.add(buttonStop);
        buttonPanel.add(resultLabel);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
