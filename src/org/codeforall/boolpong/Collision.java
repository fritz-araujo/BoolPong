package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Collision {

    private int rectX1;
    private int rectY1;
    private int rectX2;
    private int rectY2;

    public Collision(int rectX1, int rectY1, int rectX2, int rectY2) {
        this.rectX1 = rectX1;
        this.rectY1 = rectY1;
        this.rectX2 = rectX2;
        this.rectY2 = rectY2;
    }

    public boolean checkCollision(Picture ballPic) {

        int ballX = ballPic.getX();
        int ballY = ballPic.getY();
        int ballWidth = ballPic.getWidth();
        int ballHeight = ballPic.getHeight();

        return (ballX + ballWidth >= rectX1 && ballX <= rectX2) &&
                (ballY + ballHeight >= rectY1 && ballY <= rectY2);
    }
    /*NEEDS TO CALL THE PLAYER.UPDATECUPS METHOD AND SEND THAT CURRENT CUP*/
}


