package org.codeforall.boolpong;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

    //Sound class constructor
    public Sound(){
    }


    //Method for the sound to be threaded to not fix the instructions
    public void playSound(final String soundFile) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadPlaySound(soundFile);
            }
        }).start();
    }

    //Sound method logic for the sound play
    //STILL NEEDS THE CORRECT IMPLEMENTATION FOR THE SOUND TO PLAY AFTER CUP REMOVED
    public void threadPlaySound(String soundFile) {
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

}
