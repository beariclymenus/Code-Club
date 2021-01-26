package CodeClub.src;

import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import java.lang.Thread;
import java.lang.Runnable;
import javax.sound.sampled.AudioInputStream;
import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import java.io.IOException;
import java.lang.InterruptedException;

public class AudioInputTest {
    public static void main(String args[]) {
        AudioFormat format = new AudioFormat(44100, 16, 2, true, true);
        // AudioFormat(float sampleRate, int sampleSizeInBits, int channels, boolean signed, boolean bigEndian)
        // Also
        // AudioFormat(AudioFormat.Encoding encoding, float sampleRate, int
        // sampleSizeInBits, int channels, int frameSize, float frameRate, boolean
        // bigEndian)

        TargetDataLine line;
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);


        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("line is not supported");
        }

        try {
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            System.out.println("Starting");

            Thread stopper = new Thread(new Runnable() {
                public void run() {
                    AudioInputStream audioStream = new AudioInputStream(line);
    
                    File wavFile = new File("D://Recording.wav");
                    
                    try {
                        AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, wavFile);
                    } catch(IOException e) {
                        
                    }
                }
            }); //end of thread
    
            stopper.start();
            try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                
            }
            line.stop();
            line.close();
            line.start();
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        
        System.out.println("over");

    }
}
