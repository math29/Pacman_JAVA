/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Musique;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Mathieu
 */
public class MusiqueJeu extends Thread {
    private final String filename;
    private final Position curPosition;
    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb
    enum Position {LEFT, RIGHT, NORMAL};
 
    public MusiqueJeu(String wavfile) {
        filename = wavfile;
        curPosition = Position.NORMAL;
    }
 
    @Override
    public void run() {
        File soundFile = new File(filename);
        if (!soundFile.exists()) {
            System.err.println("Wave file not found: " + filename);
            return;
        }
        while(true){
            AudioInputStream audioInputStream;
            try {
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            } catch (UnsupportedAudioFileException | IOException e1) {
                return;
            }
        
            AudioFormat format = audioInputStream.getFormat();
            SourceDataLine auline;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        
            try {
               auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);
            } catch (LineUnavailableException e) {
                return;
            }
 
            if (auline.isControlSupported(FloatControl.Type.PAN)) {
                FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
                if (curPosition == Position.RIGHT) {
                    pan.setValue(1.0f);
                } else if (curPosition == Position.LEFT) {
                    pan.setValue(-1.0f);
                }
            }
        
            auline.start();
            int nBytesRead = 0;
             byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
 
            try {
                while (nBytesRead != -1) {
                    nBytesRead = audioInputStream.read(abData, 0, abData.length);
                    if (nBytesRead >= 0) {
                        auline.write(abData, 0, nBytesRead);
                    }
                }
            } catch (IOException e) {
                return;
            } finally {
                auline.drain();
                auline.close();
            }
        }
    }
}