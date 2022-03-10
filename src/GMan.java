import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;

public class GMan extends GCompound {

    private int lossProgress = 0;

    private GOval head = new GOval(65, 65);
    private GRect body = new GRect(1,100);
    private GRect arms = new GRect(70, 1);
    private GLine leftleg = new GLine(0,0,15,80);
    private GLine rightleg = new GLine(0,0,-15,80);

    public GMan(){
    }

    public boolean tickLossProgress(){
        addBodyPart();
        lossProgress += 1;
        switch (lossProgress){
            case 1-> add(head, 50, 50);
            case 2-> add(body, head.getX()+head.getWidth()/2,head.getHeight()+ head.getY());
            case 3-> add(arms, body.getX()-arms.getWidth()/2, body.getY()+20);
            case 4-> add(leftleg, head.getX()+head.getWidth()/2, 215);
            case 5-> add(rightleg, head.getX()+head.getWidth()/2, 215);
        }
        return lossProgress == 5;
    }

    private void addBodyPart(){

    }

    public int getLossProgress() {
        return lossProgress;
    }
}
