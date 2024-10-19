package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Force {

    private int force = 0; //current force
    private int delta = 1; //change in force: will alternate between positive and negative
    private boolean accumulating = false;
    private Rectangle slider;

    public Force(){
        slider = new Rectangle(10, 10,50, 50);
        slider.draw();
    }

    public int getForce() {
        return force;
    }

    //Method to reset the force - needs to be called every "round"
    public void resetForce(){
        force = 0;
        delta = 1;
        slider.translate(0, -slider.getY() + 10); //RESETS SLIDER POSITION **** STILL NEEDS TO HAVE THE CORRECT VALUES
    }

    public void startAccumulating(){
        updateForce();
        accumulating = true;
    }

    public void stopAccumulating(){
        accumulating = false;
    }

    //Continuous update between 0 and 300 (still need to test force values)
    public void updateForce(){
        force += delta;

        //Bounce back when force hits upper and lower bounds
        if(force >= 300){
            delta = -1;
        } else if (force <= 0) {
            delta = 1;
        }
        //moves the slider up and down
        slider.translate(0, delta);
    }
}
