import jm.JMC;
import jm.music.data.*;
import jm.util.*;

class RandomMelody {
    private Score score;

    public RandomMelody(String scoreTitle) {
        score = new Score(scoreTitle);
    }

    public void addASong(int instrument, int[] pitchArray) {
        Part part = new Part("Part", instrument, 0);
        Phrase phrase = new Phrase(0.0);
        // Add notes to the phrase using pitchArray and random rhythm
        for (int pitch : pitchArray) {
            double interval = Math.random() * 2; // Random interval between 0 and 2
            Note note = new Note(pitch, interval);
            phrase.addNote(note);
        }
        part.addPhrase(phrase);
        score.addPart(part);
    }

    public void play() {
        Play.midi(score);
    }

    public void save() {
        Write.midi(score, score.getTitle() + ".mid");
    }

    public static void main(String[] args) {
        RandomMelody randomMelody = new RandomMelody("MyRandomMelody");
        // Define pitchArray with 24 pitches for the song
        int[] pitchArray = {JMC.C4, JMC.D4, JMC.E4, JMC.F4, JMC.G4, JMC.A4, JMC.B4};
        // Add a song with piano instrument and pitchArray
        randomMelody.addASong(JMC.PIANO, pitchArray);
        // Play the score
        randomMelody.play();
        // Save the score as MIDI file
        randomMelody.save();
    }
}