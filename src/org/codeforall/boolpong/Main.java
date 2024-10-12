package org.codeforall.boolpong;


import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {

        //set canvas
        Canvas.setMaxX(1070); //full hd resolution -10
        Canvas.setMaxY(1910); //currently not working properly

        //set background
        Picture background = new Picture(0, 0, "assets/test.png");
        background.draw();
    }
}