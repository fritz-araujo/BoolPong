package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Ball ball;

    public Player(){
        this.ball = new Ball();
    }

    public void shoot(){
        ball.shoot();
    }
}
