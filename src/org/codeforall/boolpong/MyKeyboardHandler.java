package org.codeforall.boolpong;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboardHandler implements KeyboardHandler {

    private final Keyboard keyboard;
    private final Player player;

    public MyKeyboardHandler(Player player){
        keyboard = new Keyboard(this);
        setKeyboardEvents();
        this.player = player;
    }

    public void setKeyboardEvents(){
        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            player.shoot();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}