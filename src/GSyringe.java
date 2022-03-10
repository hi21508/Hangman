import acm.graphics.GCompound;
import acm.graphics.GRect;

public class GSyringe extends GCompound {
    private GRect needle = new GRect(30,1);
    private GRect tube = new GRect (30, 20);
    private GRect xHandle = new GRect(10,1);
    private GRect yHandle = new GRect( 1, 20);

    public GSyringe(){

        add(needle, 140, 85);
        add(tube, needle.getX()+needle.getWidth(), needle.getY()-tube.getHeight()/2);
        add(xHandle, tube.getX()+ tube.getWidth(),needle.getY());
        add(yHandle, xHandle.getX()+xHandle.getWidth(),tube.getY());
    }

}
