import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.util.Random;

public class LethalInjectionMan extends GraphicsProgram{

    private Letterbox letterbox;

    private Dialog dialog;
    private boolean gameOver = false;
    private GLabel endMessage;
    private GSyringe gSyringe = new GSyringe();
    private String[] wordList;
    private Random rng;

    private void initWord(){
        letterbox = new Letterbox(wordList[rng.nextInt(wordList.length)]);
        add(letterbox);
    }

    private String askGuess(){
        return svu.csc213.Dialog.getString("Guess a letter.");
    }

    public boolean checkChar(String word){
        return word.length()==1;
    }

    private void gameLoop(){
        String guess = askGuess();
        //check if the guess is a single character
        if (checkChar(guess)){
            letterbox.checkChar(guess.charAt(0));
            if(letterbox.getLost()){
                lose();
            }
            System.out.println(letterbox.getWinProgress());
            if(letterbox.getWinProgress()>=letterbox.getWord().length()){
                win();
            }
        }else {
            if(letterbox.checkStringValid(guess)){
                letterbox.showWord();
                win();
            }else {
                lose();
            }
        }

    }

    public void win(){
        letterbox.handleWin();
        endMessage = new GLabel("You Win!");
        endMessage.setFont("Times New Roman-50-BOLD");
        add(endMessage, getWidth()/2-endMessage.getWidth()/2, getHeight()/2-endMessage.getHeight()/2);
        remove(gSyringe);
        gameOver = true;
    }

    public void lose(){
        letterbox.handleLoss();
        endMessage = new GLabel("You Lose.");
        endMessage.setFont("Times New Roman-50-BOLD");
        add(endMessage, getWidth()/2-endMessage.getWidth()/2, getHeight()/2-endMessage.getHeight()/2);
        gameOver = true;
    }

    private void initWordList(){
        wordList = new String[]{"abruptly", "abyss", "affix", "askew", "bayou", "beekeeper", "bikini", "boxcar", "buzzwords", "cobweb", "crypt", "cycle", "disavow", "dwarves", "equip", "espionage", "faking", "fixable", "fjord", "galvanize", "glowworm", "glitch", "haiku", "hyphen", "injury", "ivory", "jackpot", "jigsaw", "jogging", "juicy", "keyhole", "kiosk", "kazoo","limping", "mystify", "nowadays", "oxygen", "pajama", "pixel", "pneumonia", "quartz", "queue", "rhythm", "shiv", "scratch", "strength", "staff", "subway", "transcript", "lengths", "taxable", "unzip", "velociraptor","vortex", "voyeurism", "waxy", "wizard", "xylophone", "youthful", "yummy", "zigzag", "zipper", "zodiac"};

    }

    @Override
    public void init(){
        initWordList();
        rng = new Random();
        initWord();
        add(gSyringe);
    }

    @Override
    public void run(){
        while (!gameOver){
            gameLoop();
        }
    }

    public static void main(String[] args) {
        new LethalInjectionMan().start();
    }
}
