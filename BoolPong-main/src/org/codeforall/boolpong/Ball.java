package org.codeforall.boolpong;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball {

    public static volatile boolean idle = true;
    private Picture ballPic;
    private int drunk = 6;
    private int randomizerPosition;

    private boolean ballShot = false;

    public void setBallShot(boolean ballShot) {
        this.ballShot = ballShot;
    }

    public Ball(){
        ballPic = new Picture(220, 750, "assets/ball.png");
        ballPic.draw();
    }

    public void shoot(){
        randomizerPosition = 400 + (int)(Math.random()*250);
        int i = 0;
        while (i < randomizerPosition){
            ballPic.translate(0, -1);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }

    }

    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                idle();
            }
        }).start();
    }

    public void idle(){
        while (idle && !ballShot){
            ballMovement();
        }
    }

    public void ballMovement(){
        if (ballPic.getX() == 0) {
            while (ballPic.getX() < 410 && idle && !ballShot) {
                ballPic.translate(5, 0);
                try {
                    Thread.sleep(drunk);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (ballPic.getX() == 410) {
            while (ballPic.getX() > 0 && idle && !ballShot) {
                ballPic.translate(-5, 0);
                try {
                    Thread.sleep(drunk);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            ballPic.translate(-5, 0);
        }
    }
}
