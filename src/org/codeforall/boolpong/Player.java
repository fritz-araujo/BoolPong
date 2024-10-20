package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    //Player class properties
    private final String PREFIX = "resources/";
    private Ball ball;
    private int allCupsDown = 6;
    private Cups[] cups = new Cups[6];
    private Collision collision;
    Sound sound = new Sound();
    private int gameStarted = 0;
    Player selfReference;

    //Player class constructor
    public Player(){
        this.selfReference = this;
        this.collision = new Collision();
    }

    public void checkForCollision() {
        int ballX = ball.getX();  // Get ball's current X position
        int ballY = ball.getY();

        int hitCupIndex = collision.checkCollision(ballX, ballY);

        if (hitCupIndex != -1) {
            // If a cup was hit, remove it
            cups[hitCupIndex].cupRemover();
            System.out.println("Cup " + hitCupIndex + " was hit and removed!");
        }
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
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // Wait until the ball finishes shooting
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Check for collision after the ball stops
                    checkForCollision();
                }
            }).start();
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

    public void gameStart() {
        Picture start = new Picture(0, 0, PREFIX + "entrada.gif");
        if (gameStarted == 0) {
            start.draw();
            gameStarted++;
        }
        else if (gameStarted == 1){
            start.delete();
            Picture background = new Picture(0, 0, PREFIX + "background.png");
            Picture table = new Picture(0, 200, PREFIX + "table.png");
            background.draw();
            table.draw();
            createCups();
            newBall();
            gameStarted++;
        }
    }

}
