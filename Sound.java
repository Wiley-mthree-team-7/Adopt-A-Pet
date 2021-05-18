import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;
import java.util.*;

class Sound {
    private URL url;
    private Clip clip;
    private String filename;
    public Sound(String requestedSound) {
        this.filename = requestedSound;
        url = this.getClass().getResource(requestedSound);
        if (url != null) {
            try {
                // Open an audio input stream.
                // Get a sound clip resource.
                // Open audio clip and load samples from the audio input stream.
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(audioInput);


            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void play() throws Exception {
        System.out.println(AnsiColours.RED + "Playing... " + filename);        
        clip.setFramePosition(0);
        clip.start();
        Thread.sleep(4000);
        System.out.println(AnsiColours.GREEN + "Finished playing");        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        filename = filename.length() == 0 ? "siberian_husky.wav" : filename;
        Sound sound = new Sound(filename);
        sound.play();
    }
        
}
