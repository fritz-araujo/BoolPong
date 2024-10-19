package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    //Player class properties
    private final String PREFIX = "resources/";
    private Ball ball;
    private int allCupsDown = 6;
    private Cups[] cups = new Cups[6];
    Sound sound = new Sound();
    Player selfReference;

    //Player class constructor
    public Player(){
        this.selfReference = this;
        createCups();
    }

    public void setAllCupsDown(){
        ball.setDrunk();
        allCupsDown--;
        sound.playSound(PREFIX + "glug.wav");
    }

    //Game start, creates a ball if we have cups, and the ball stays moving until method "shoot"
    public void newBall(){
        if (allCupsDown != 0) {
            if (ball != null) {
                ball.removeBall();
                /*NEEDS THE COLISION METHOD TO BE CALLED*/
            }
            if (allCupsDown != 0) {
                this.ball = new Ball();
                ball.stayMoving();

            }else restartGame(); /*TO BE CHECKED*/
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

    public void updateCups(Cups currentCup){
        if (currentCup.equals(cups[0])){ cups[0].cupRemover();}
        if (currentCup.equals(cups[1])){ cups[1].cupRemover();}
        if (currentCup.equals(cups[2])){ cups[2].cupRemover();}
        if (currentCup.equals(cups[3])){ cups[3].cupRemover();}
        if (currentCup.equals(cups[4])){ cups[4].cupRemover();}
        if (currentCup.equals(cups[5])){ cups[5].cupRemover();}
    }

    //Instantiates all the cups and saves them on cups array
    public void createCups(){
        Cups cup5 = new Cups(new Picture(272,216,PREFIX + "Red-3-3.png"),selfReference);
        Cups cup4 = new Cups(new Picture(193,216,PREFIX + "Red-3-2.png"),selfReference);
        Cups cup3 = new Cups(new Picture(114,216,PREFIX + "Red-3-1.png"),selfReference);
        Cups cup2 = new Cups(new Picture(228,254,PREFIX + "Red-2-2.png"),selfReference);
        Cups cup1 = new Cups(new Picture(148,254,PREFIX + "Red-2-1.png"),selfReference);
        Cups cup0 = new Cups(new Picture(186,293,PREFIX + "Red-1-1.png"),selfReference);

        cups[0] = cup0;
        cups[1] = cup1;
        cups[2] = cup2;
        cups[3] = cup3;
        cups[4] = cup4;
        cups[5] = cup5;
    }

    //GAME FLOW STUFF
    public void restartGame(){
        System.out.println("game restarted"); /*STILL NEEDS TO BE WORKED ON*/
    }

    public void quitGame(){
        System.exit(0);
    }
}
