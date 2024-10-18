package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cups {
    //Cups class properties
    private boolean wasHit = false;
    private Picture sprite;

    //Cups class constructor
    public Cups (Picture sprite){
        this.sprite = sprite;
        sprite.draw();
    }
}
