package gov.edu.anm.presenter.domain.utils;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SoundsUtils {
    public static void playTimeOutSound() {
        try {
            File file = new File("src/gov/edu/anm/presenter/assets/sounds/TimeOut.wav");
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            Clip audio = AudioSystem.getClip();
            audio.open(inputStream);
            audio.start();
        }
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            JOptionPane.showMessageDialog(null, "Erro ao reproduzir aúdio:\n" + e.getMessage());
        }
    }


}
