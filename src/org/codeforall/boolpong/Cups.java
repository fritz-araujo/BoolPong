package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cups {

    //Cups class properties
    private boolean wasHit = false;
    private Picture sprite;
    private Player player;

    //Cups class constructor
    public Cups (Picture sprite,Player player){
        this.player = player;
        this.sprite = sprite;
        sprite.draw();
    }
    public int getXPos() {
        return sprite.getX();
    }

    public int getYPos() {
        return sprite.getY();
    }

    public int getWidth() {
        return sprite.getWidth();
    }

    public int getHeight() {
        return sprite.getHeight();
    }

    //Cup remover
    public void cupRemover(){
        sprite.delete();
        player.setAllCupsDown();

    }
}
