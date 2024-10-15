package org.codeforall.boolpong;

public class Player {

    private String name;
    private Ball ball;
    private int score;

    public Player(String name){
        this.name = name;
        this.ball = new Ball();
        this.score = 0;
        ball.start();
    }

    private int getScore(){
        return score;
    }

    public void shoot(){
        ball.shoot();
        ball.setBallShot(true);

        //if ball hits cup, score++;
    }
}
