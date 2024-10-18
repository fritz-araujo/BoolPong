package org.codeforall.boolpong;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {

        //set canvas
        Canvas.setMaxX(440); //background resolution -10
        Canvas.setMaxY(790);

        //set background
        Picture background = new Picture(0, 0, "assets/new800x450_px/background.png");
        Picture table = new Picture(0, 200,"assets/new800x450_px/table.png");
        background.draw();
        table.draw();

        //CREATE CUP ARRAY! with position with the right sprites
        //set players - creates a ball
        Player player1 = new Player();

        //initialise keyboard
        new MyKeyboardHandler(player1);

        //game initialisation
        player1.startGame();

        Field field;
        field = new Field(22, 40);
    }
}