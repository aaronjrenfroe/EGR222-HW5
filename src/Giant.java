import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.awt.*;

/**
 * Created by AaronR on 10/23/16.
 */
public class Giant extends Critter {
    private int stepNumber = 0;
    // This method should be overriden (default action is turning left)
    public Action getMove(CritterInfo info) {

        if (info.getFront() == Neighbor.OTHER) {
            //System.out.println("Giant is infecting");
            return Action.INFECT;
        } else if (info.getFront() != Neighbor.WALL && info.getFront() != Neighbor.SAME){
            return Action.HOP;
        } else{
            return Action.RIGHT;
        }
    }

    // This method should be overriden (default color is black)
    public Color getColor() {
    return Color.GRAY;

    }
    // This method should be overriden (default display is "?")

    public String toString() {
        String myString;
        if (stepNumber == 24){
            stepNumber = 0;
        }

        if (this.stepNumber / 6 == 0) {
            myString  ="fee";
        }
        else if (this.stepNumber / 6 == 1) {
            myString = "fie";
        }
        else if (this.stepNumber / 6 == 2) {
            myString = "foe";
        }

        else myString = "fum";
        stepNumber++;
        return myString;


    }
}

