import acm.graphics.GCompound;
import acm.graphics.*;

public class Letterspace extends GCompound {
    private char letter;
    public int spaceNumber;
    public GLine gSpace;
    public GLabel gLetter;
    private boolean guessed = false;

    public Letterspace(char charmander, int number){
        letter = charmander;
        spaceNumber = number;
        gSpace = new GLine(10+spaceNumber*50, 350, spaceNumber*50+40,350);
        add(gSpace);

    }

    public char getLetter() {
        return letter;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void showCorrect(){
        gLetter = new GLabel(Character.toString(letter));
        gLetter.setFont("Times New Roman-BOLD-40");
        add(gLetter,gSpace.getStartPoint());
        guessed = true;
    }
}
