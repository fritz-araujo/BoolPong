package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball {

    private Picture ballPic;

    public Ball(){
        ballPic = new Picture(220, 750, "assets/ball.png");
        ballPic.draw();
    }

    public void shoot(){
        ballPic.translate(0, 50);
    }

    public void ballMovement(){
        //side to side (before shooting) method
    }
}
