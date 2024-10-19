package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    //Player class properties
    private final String PREFIX = "resources/";
    private Ball ball;
    private int allCupsDown = 6;
    private Cups[] cups = new Cups[6];
    private Sound sound = new Sound();
    private Force force;
    private boolean forceAccumulating = false;

    //Player class constructor
    public Player(){
        createCups();
        force = new Force();
    }

    //Game start, creates a ball if we have cups, and the ball stays moving until method "shoot"
    public void newBall(){
        if (allCupsDown != 0) {
            if (ball != null) {
                ball.removeBall();
            }
            this.ball = new Ball(force);
            ball.stayMoving();
            force.resetForce();
        }
    }

    //Handles the shooting process with the force accumulation mechanic
    public void beforeShoot() {
        if (!ball.getBallShot()) {
            if (!forceAccumulating) {
                // Stop the ball from moving and start accumulating force
                ball.stopIdleMovement();
                force.startAccumulating();
                forceAccumulating = true;
            }
        }
    }

    public void shoot() {
        // Stop accumulating, shoot the ball, and play sound
        force.stopAccumulating();
        ball.threadShoot(); // Shoot using accumulated force
        forceAccumulating = false; // Reset the accumulation flag
    }

    //Instantiates all the cups and saves them on cups array
    public void createCups(){
        Cups cup5 = new Cups(new Picture(272,216,PREFIX + "Red-3-3.png"));
        Cups cup4 = new Cups(new Picture(193,216,PREFIX + "Red-3-2.png"));
        Cups cup3 = new Cups(new Picture(114,216,PREFIX + "Red-3-1.png"));
        Cups cup2 = new Cups(new Picture(228,254,PREFIX + "Red-2-2.png"));
        Cups cup1 = new Cups(new Picture(148,254,PREFIX + "Red-2-1.png"));
        Cups cup0 = new Cups(new Picture(186,293,PREFIX + "Red-1-1.png"));

        cups[0] = cup0;
        cups[1] = cup1;
        cups[2] = cup2;
        cups[3] = cup3;
        cups[4] = cup4;
        cups[5] = cup5;
    }


    //Player can restart game
    public void restartGame(){
        System.out.println("game restarted"); /*STILL NEEDS TO BE WORKED ON*/
    }

    //Player can quit game
    public void quitGame(){
        System.exit(0);
    }
}
