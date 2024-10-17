package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private final String PREFIX = "assets/";

    private Ball ball;
    private int allCupsDown = 6;
    private Cups[] cups = new Cups[6];

    public Player(){
        showCups();
    }

    public void startGame(){
        if (allCupsDown != 0) {
            this.ball = new Ball();
            ball.stayMoving();
        }
    }

    public void shoot(){
        ball.setBallShot(true);
        ball.threadShoot();

    }


    public void showCups(){
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
