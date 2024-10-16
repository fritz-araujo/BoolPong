package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Ball ball;
    private Cups[] cups = new Cups[6];
    private int allCupsDown = 6;

    public Player(){
        showCups();
    }

    public void startGame(){
        if (allCupsDown != 0) {
            this.ball = new Ball();
            ball.start();
        }
    }

    public void shoot(){
        ball.setBallShot(true);
        ball.shoot();

    }

    public void showCups(){
        Cups cup0 = new Cups(new Picture(1,1,"assets/background.png"));
        Cups cup1 = new Cups(new Picture(1,1,"assets/background.png"));
        Cups cup2 = new Cups(new Picture(1,1,"assets/background.png"));
        Cups cup3 = new Cups(new Picture(1,1,"assets/background.png"));
        Cups cup4 = new Cups(new Picture(1,1,"assets/background.png"));
        Cups cup5 = new Cups(new Picture(1,1,"assets/background.png"));
        cups[0] = cup0;
        cups[1] = cup1;
        cups[2] = cup2;
        cups[3] = cup3;
        cups[4] = cup4;
        cups[5] = cup5;
    }
}
