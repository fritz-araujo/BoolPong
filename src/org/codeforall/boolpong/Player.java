package org.codeforall.boolpong;

public class Player {

    private Ball ball;

    public Player(){
        this.ball = new Ball();
        ball.start();
    }

    public void shoot(){
        ball.shoot();
        ball.setBallShot(true);
    }
}
