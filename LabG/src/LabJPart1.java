import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class LabJPart1 {
    // Define custom constant for snare drum pitch
    private static final int SNARE_DRUM_PITCH = 38;

    public void generateRandomNotes(int maxInterval) {
        Phrase phrase = new Phrase(0.0);
        for (int i = 0; i < 24; i++) {
            // Generate random interval between 0 and maxInterval
            double interval = Math.random() * maxInterval;
            // Create a Note object with pitch 38 (snare drum) and random interval
            Note note = new Note(SNARE_DRUM_PITCH, interval);
            // Add the note to the phrase
            phrase.addNote(note);
        }
        // Play the generated phrase
        Play.midi(phrase);
    }

    public static void main(String[] args) {
        LabJPart1 randomRhythm = new LabJPart1();
        // Generate random notes with maxInterval of 2
        randomRhythm.generateRandomNotes(2);
    }
} 