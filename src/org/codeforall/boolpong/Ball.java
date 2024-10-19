package org.codeforall.boolpong;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball {

    //Ball class properties
    private final String PREFIX = "resources/";
    public static volatile boolean idle = true;
    private Picture ballPic;
    private static int drunk = 6;
    private int randomizerPosition;
    private boolean ballShot = false;


    //Setter for the ball shot to update, when the ball has been shot
    public void setBallShot(boolean ballShot) {
        this.ballShot = ballShot;
    }

    //Getter for the ball shot to check if the ball has been shot already
    public boolean getBallShot(){
        return ballShot;
    }

    //Setter for the drunk int
    public void setDrunk(){
        drunk--;
    }

    //Ball class constructor gets the ball picture and .draw's it
    public Ball(){
        ballPic = new Picture(220, 750, PREFIX + "ball.png");
        ballPic.draw();
    }

    //Method to remove the current ball from the screen
    public void removeBall(){
        ballPic.delete();
    }

    //Controls all the ball movement up after it has been shot
            //Makes a new thread, so it checks every instance, in order to get a smooth movement
    public void threadShoot() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                shoot();
            }
        }).start();
    }

            //Actual shoot logic, right now at random
            /*NEEDING UPDATE WITH THE BALL FORCE!!*/
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

    //Controls all the side to side movement of the ball
                //Makes a new thread so the idle movement doesn't block every other instruction
    public void stayMoving(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                idle();
            }
        }).start();
    }

            //Controls if the ball is still idle(moving side to side) and the space to shot hasn't been triggered
    public void idle(){
        while (idle && !ballShot){
            ballMovementIdle();
        }
    }

            //The moving of the ball when the game starts, side to side
    public void ballMovementIdle(){
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

    //End of ball side to side control
}
