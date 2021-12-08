package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private Component canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private static final int POCKET_SIZE = 36;
    private JLabel resultLabel;
    public boolean isInPocket = false;

    public Ball(Component c, JLabel resultLabel){
        this.canvas = c;
        this.resultLabel = resultLabel;

        if(Math.random()<0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public static void f(){
        int a = 0;
    }

    public void draw (Graphics2D g2){
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));

    }

    public boolean move(){
        if (this.isInPocket) return false;
        x+=dx;
        y+=dy;
        checkIsInBilliardPocket();
        if (this.isInPocket) {
            ((BallCanvas) this.canvas).remove(this);
            this.canvas.repaint();
            BallCanvas.ballCounter++;
            resultLabel.setText("Result: " + BallCanvas.ballCounter);
            return true;
        } else {
            if(x<0){
                x = 0;
                dx = -dx;
            }
            if(x+XSIZE>=this.canvas.getWidth()){
                x = this.canvas.getWidth()-XSIZE;
                dx = -dx;
            }
            if(y<0){
                y=0;
                dy = -dy;
            }
            if(y+YSIZE>=this.canvas.getHeight()){
                y = this.canvas.getHeight()-YSIZE;
                dy = -dy;
            }
            this.canvas.repaint();
            return false;
        }
    }
    public void checkIsInBilliardPocket() {
        if ((x <= (POCKET_SIZE - XSIZE) &&
                (y <= (POCKET_SIZE - YSIZE) ||
                 y >= (this.canvas.getHeight() - POCKET_SIZE))) ||
            (x >= (this.canvas.getWidth() - POCKET_SIZE) &&
                (y <= (POCKET_SIZE - YSIZE) ||
                 y >= (this.canvas.getHeight() - POCKET_SIZE)))
        ) {
            this.isInPocket = true;
        }
    }
}
