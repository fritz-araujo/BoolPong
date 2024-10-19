package org.codeforall.boolpong;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball {

    //Ball class properties
    private final String PREFIX = "resources/";
    public static volatile boolean idle = true;
    private Picture ballPic;
    private int drunk = 6;
    private boolean ballShot = false;
    private boolean isForceAccumulating = false;
    private Force force;

    //Ball class constructor gets the ball picture and .draw's it
    public Ball(Force force){
        this.force = force;
        ballPic = new Picture(220, 750, PREFIX + "ball.png");
    }

    //Getters and Setters
    //Getter for the ball shot to check if the ball has been shot already
    public boolean getBallShot(){
        return ballShot;
    }

    public boolean isForceAccumulating() {
        return isForceAccumulating;
    }

    //Setter for the ball shot to update, when the ball has been shot
    public void setBallShot(boolean ballShot) {
        this.ballShot = ballShot;
    }


    //method to stop the side-to-side movement after space is pressed once
    public void stopIdleMovement(){
        idle = false; //Stops idle movement
    }

    public void startForceAccumulation(){
        if(!ballShot && !isForceAccumulating){
            isForceAccumulating = true;
            force.resetForce();
            System.out.println("Force accumulation has started :)");
        }
    }


    public void releaseBall(){
        if(!ballShot && isForceAccumulating){
            isForceAccumulating = false;//stops accumulating force
            System.out.println("Force accumulation has stopped :)");
            shoot(force.getForce());
        }
    }


    //Method to remove the current ball from the screen
    public void removeBall(){
        ballPic.delete();
    }

    //Method that starts a new thread to shoot the ball
    //Controls all the ball movement up after it has been shot
    //Makes a new thread, so it checks every instance, in order to get a smooth movement
    public void threadShoot(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                shoot(force.getForce()); // Shoot the ball with the current force
            }
        }).start();
    }

    // Shoot/Move the ball up, based on the captured force
    public void shoot(int force) {
        int i = 0;
        while (i < force) {
            ballPic.translate(0, -1); // Move the ball up by 1 pixel
            try {
                Thread.sleep(1); // Delay for smooth animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
        setBallShot(true); //mark the ball as shot after it has moved the appropriate number of pixels.
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

    // The moving of the ball when the game starts, side to side
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
