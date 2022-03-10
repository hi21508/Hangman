import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;

import java.util.Timer;

public class Letterbox extends GCompound {

    private String word;
    private char[] guessedLetters = new char[5];
    private Letterspace[] letterspaces;
    private GRect box;
    private GLabel[] GguessedLetters = new GLabel[5];
    private GMan gMan;
    private boolean lost = false;
    private int winProgress = 0;

    public Letterbox(String word) {
        this.word = word;
        letterspaces = new Letterspace[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letterspaces[i] = new Letterspace(word.charAt(i), i);
            add(letterspaces[i]);
        }
        gMan = new GMan();
        box = new GRect(300, 100, 300, 200);
        add(box);
        add(gMan);
    }

    public void checkChar(char charmander) {
        for (int i = 0; i < 4; i++) {
            if(guessedLetters[i]==charmander){
                return;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            if (letterspaces[i].getLetter()==charmander&&letterspaces[i].isGuessed()){
                return;
            }
        }

        boolean letterCorrect = false;
        for (int i = 0; i < letterspaces.length; i++) {
            if (letterspaces[i].getLetter() == charmander) {
                letterspaces[i].showCorrect();
                letterCorrect = true;
                winProgress += 1;
            }
        }

        if (!letterCorrect){
            addToBox(charmander, gMan.getLossProgress());
        }
    }

    public boolean checkStringValid(String input){
        return input.equals(word);
    }

    public void addToBox(char wrongLetter, int lossProgress){
        guessedLetters[lossProgress] = wrongLetter;
        GguessedLetters[lossProgress] = new GLabel(Character.toString(wrongLetter));
        GguessedLetters[lossProgress].setFont("Times New Roman-BOLD-40");
        add(GguessedLetters[lossProgress], 310+lossProgress*50, 150);
        lost = gMan.tickLossProgress();
    }

    public String getWord() {
        return word;
    }

    public void showWord(){
        for (int i = 0; i < letterspaces.length; i++) {
            letterspaces[i].showCorrect();
        }
    }

    public void handleWin(){
        removeAll();
        for (int i = 0; i < word.length(); i++) {
            add(letterspaces[i]);
        }
    }
    public void handleLoss(){
        removeAll();
        add(gMan);
    }

    public boolean getLost(){
        return lost;
    }

    public int getWinProgress() {
        return winProgress;
    }
}
