package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Picture ballPicture;

    public Player(){
        ballPicture = new Picture(220, 700, "assets/ball.png");
        ballPicture.draw();
    }
}
