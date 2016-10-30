import com.sun.xml.internal.xsom.impl.WildcardImpl;

import java.awt.*;

/**
 * Created by AaronR on 10/23/16.
 */
public class Bear extends Critter {
    private boolean polar;
    public int stepNumber = 0;

    public Bear(boolean polar){
        this.polar = polar;
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        else if(info.getFront() != Neighbor.WALL && info.getFront() != Neighbor.SAME){
            return Action.HOP;
        }
        else return Action.RIGHT;

    }

    // This method should be overriden (default color is black)
    public Color getColor(){
        if (this.polar == true) {
            return Color.WHITE;
        }
        else return Color.BLACK;
    }

    // This method should be overriden (default display is "?")
    public String toString() {
        if (stepNumber == 0) {
            this.stepNumber++;
            return "\\";

        } else {
            this.stepNumber = 0;
            return "/";

        }
    }

}
