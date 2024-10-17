package org.codeforall.boolpong;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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

    private void playSound(String soundFile) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 650);
            System.out.println("Playing sound: " + soundFile);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == keyboardEvent.KEY_SPACE){
            player.shoot();
            System.out.println("shoot!");
            playSound("C:\\Users\\rodol\\Downloads\\BoolPong-main\\assets\\Sound\\glug-glug-glug-39140.wav");
            playSound("C:\\Users\\rodol\\Downloads\\BoolPong-main\\assets\\Sound\\big-burp-36175.wav");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
