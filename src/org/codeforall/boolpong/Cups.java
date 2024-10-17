package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cups {
    private boolean wasHit = false;
    //private static Cups[] cups = new Cups[6];
    private Picture sprite;


    public Cups (Picture sprite){
        this.sprite = sprite;
        sprite.draw();
    }
}
