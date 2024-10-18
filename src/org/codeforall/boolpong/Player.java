package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    //Player class properties
    private final String PREFIX = "assets/";
    private Ball ball;
    private int allCupsDown = 6;
    private Cups[] cups = new Cups[6];

    //Player class constructor
    public Player(){
        createCups();
    }

    //Game start, creates a ball if we have cups, and the ball stays moving until method "shoot"
    public void newBall(){
        if (allCupsDown != 0) {
            this.ball = new Ball();
            ball.stayMoving();
        }
    }

    //Method checks first if the ball has been shot, if not shots the ball and marks the setter as true
    //if not makes a new ball and gets it moving again for the new try
    public void shoot(){
        if (!ball.getBallShot()){
            ball.setBallShot(true);
            ball.threadShoot();
        } else newBall();
    }

    //Instantiates all the cups and saves them on cups array
    public void createCups(){
        Cups cup5 = new Cups(new Picture(272,216,PREFIX + "new800x450_px/Red-3-3.png"));
        Cups cup4 = new Cups(new Picture(193,216,PREFIX + "new800x450_px/Red-3-2.png"));
        Cups cup3 = new Cups(new Picture(114,216,PREFIX + "new800x450_px/Red-3-1.png"));
        Cups cup2 = new Cups(new Picture(228,254,PREFIX + "new800x450_px/Red-2-2.png"));
        Cups cup1 = new Cups(new Picture(148,254,PREFIX + "new800x450_px/Red-2-1.png"));
        Cups cup0 = new Cups(new Picture(186,293,PREFIX + "new800x450_px/Red-1-1.png"));

        cups[0] = cup0;
        cups[1] = cup1;
        cups[2] = cup2;
        cups[3] = cup3;
        cups[4] = cup4;
        cups[5] = cup5;
    }

}
