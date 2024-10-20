package org.codeforall.boolpong;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {

        final String PREFIX = "";

        //set canvas
        Canvas.setMaxX(440); //background resolution -10
        Canvas.setMaxY(790);

        //CREATE CUP ARRAY! with position with the right sprites
        //set players - creates a ball
        Player player1 = new Player();

        //initialise keyboard
        new MyKeyboardHandler(player1);

        //game initialisation
        player1.gameStart();

//        Field field;
//        field = new Field(22, 40);
    }
}