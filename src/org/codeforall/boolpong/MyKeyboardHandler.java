package org.codeforall.boolpong;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;

    public MyKeyboardHandler(Player player){
        keyboard = new Keyboard(this);
        setKeyboardEvents();
        this.player = player;
    }

    public void setKeyboardEvents(){
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_SPACE);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == keyboardEvent.KEY_SPACE){
            System.out.println("shoot!"); //shootBall();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
