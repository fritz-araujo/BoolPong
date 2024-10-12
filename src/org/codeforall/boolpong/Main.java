package org.codeforall.boolpong;


import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {

        //set canvas
        Canvas.setMaxX(440); //background resolution -10
        Canvas.setMaxY(790); //currently not working properly

        //set background
        Picture background = new Picture(0, 0, "assets/background.png");
        background.draw();

        //set players
        Player player1 = new Player();

    }
}