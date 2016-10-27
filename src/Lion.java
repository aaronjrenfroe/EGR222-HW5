import java.awt.*;
import java.util.Random;

/**
 * Created by AaronR on 10/23/16.
 */
public class Lion extends Critter {
    public int stepNumber = 0;
    public Color currentColor;
    // This method should be overriden (default action is turning left)
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        }
        else if (info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }
        else return Action.HOP;
    }

    // This method should be overriden (default color is black)
    public Color getColor() {

        if (stepNumber == 3){
            stepNumber = 0;
        }
        if (stepNumber == 0) {

            int randNumber = 1 + (int) (Math.random() * 3);
            if (randNumber == 1) {
                currentColor = Color.RED;
            } else if (randNumber == 2) {
                currentColor = Color.BLUE;
            } else currentColor = Color.GREEN;

        }
        stepNumber++;
        return currentColor;
    }
    // This method should be overriden (default display is "?")

    public String toString() {
        return "L";
    }
}
