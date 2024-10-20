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
        this.player = player;
        setKeyboardEvents();
    }

    public void setKeyboardEvents(){

        //ENTER - startGame()
        KeyboardEvent startGame = new KeyboardEvent();
        startGame.setKey(KeyboardEvent.KEY_ENTER);
        startGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(startGame);

        //SPACE - shoot()
        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        //R - restart()
        KeyboardEvent restartGame = new KeyboardEvent();
        restartGame.setKey(KeyboardEvent.KEY_R);
        restartGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(restartGame);

        //ESC - quitGame()
        KeyboardEvent quitGame = new KeyboardEvent();
        quitGame.setKey(KeyboardEvent.KEY_ESC);
        quitGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(quitGame);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //ENTER - startGame()
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_ENTER){ /*STILL NEEDS TO BE WORKED ON*/
            System.out.println("STARTING KEY WORKING");
        }

        //SPACE - shoot()
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            player.shoot();
        }

        //R - restart()
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_R){ /*STILL NEEDS TO BE WORKED ON*/
            System.out.println("RESTARTED KEY WORKING");
        }

        //ESC - quitGame()
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_ESC){
            player.quitGame();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}