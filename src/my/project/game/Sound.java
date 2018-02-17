package my.project.game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

public class Sound {

    private String inFile=null;
    private Clip clip=null;
    private FloatControl volume=null;
    private float levelVolume=0;
    private  boolean isLiveSound = false;
    private  boolean isPlaySound = false;

    Sound(float levelVolume, String inFile){
        this.levelVolume=levelVolume;
        this.inFile=inFile;
    }

     void sound(){
        try {
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(inFile));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                  if (event.getType()==LineEvent.Type.STOP){
                      isPlaySound=false;
                      synchronized (clip){
                          clip.notify();
                      }
                  }
                }
            });
            volume = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            clip.setFramePosition(0);
            clip.start();
               isLiveSound=true;
        } catch (LineUnavailableException |UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
            isLiveSound=false;
        }

    }

     void playSound(boolean breakSound){
        if(isLiveSound){
            if(breakSound){
                clip.stop();
                clip.setFramePosition(0);
                clip.start();
                isPlaySound=true;
            }else if(!isPlaySound()){
                clip.setFramePosition(0);
                clip.start();
                isPlaySound=true;
            }
        }
    }

     void playSound(){
        playSound(true);
    }

    public void waitPlay(){
        if(!isLiveSound) return;
        synchronized (clip){
            while (isPlaySound){
                try {
                    clip.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    boolean isPlaySound (){
        return isPlaySound;
    }

     void stopPlay(){
        if(isPlaySound){
            clip.stop();
            clip.setFramePosition(0);
        }
    }

    int getFramePosition(){
         if(clip != null) {
             return clip.getFramePosition();
         }
        return 0;
    }

    public int getFrameLenght(){ return clip.getFrameLength();}

    void setFramePosition(){
        if(isPlaySound){
            clip.setFramePosition(0);
        }
    }

    void setLoop(){
        clip.loop(18);
    }

    public void setVolume(){

        if(levelVolume<0){levelVolume = 0;}
        if(levelVolume>1){levelVolume = 1;}

     float min = volume.getMinimum();
     float max = volume.getMaximum();
     volume.setValue((max-min)*levelVolume+min);

    }

}
