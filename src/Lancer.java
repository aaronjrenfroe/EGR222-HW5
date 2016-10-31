

/**
 * Created by AaronR on 10/23/16.
 */



import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.*;


public class Lancer extends Critter {
    private final int okToSweep = 3000;
    private static boolean sweepNow= false;
    static boolean found = false;
    static boolean past100 = false;
    int steps = 0;

    boolean inCorner = false;
    boolean turn = true;
    boolean armed = false;




    public Action getMove(CritterInfo info) {
        steps++;
        if (steps >= okToSweep || sweepNow){
            if (!sweepNow) {
                sweepNow = true;
            }
            return sweep(info);
        }
        else if (past100){
            // infect if enemy is in front
            if (info.getFront() == Neighbor.OTHER) {
                return Action.INFECT;
            }
            // Head to the South West Corner

            if (!inCorner) {
                switch (info.getDirection()) {

                    case NORTH: {
                        return Action.LEFT;

                    }
                    case WEST: {
                        if ((info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) && (info.getLeft() == Neighbor.WALL || info.getLeft() == Neighbor.SAME)) {
                            inCorner = true;
                            return Action.RIGHT;
                        } else {
                            if (info.getFront() == Neighbor.WALL){
                                return Action.LEFT;
                            }
                            return Action.HOP;
                        }
                    }
                    case SOUTH: {
                        if ((info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) && (info.getRight() == Neighbor.WALL || info.getRight() == Neighbor.SAME)) {
                            inCorner = true;
                            return Action.LEFT;
                        } else {
                            if (info.getFront() == Neighbor.WALL){
                                return Action.RIGHT;
                            }
                            return Action.HOP;
                        }
                    }
                    default:// if east
                        return Action.RIGHT;

                }
            }
            return inCorner(info);
        }
        else{
             if (steps == 1) {

                 past100 = true;
             }
             // be a Giant

            if (info.getFront() == Neighbor.OTHER) {
                return Action.INFECT;
            } else if (info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME){

                return Action.RIGHT;
            } else{

                return Action.HOP;

            }
        }
    }

    public Action sweep(CritterInfo info){
        int sweepNow = okToSweep;
        if (steps == sweepNow) {

            if (info.getDirection() != Direction.NORTH){
                return Action.LEFT;
            } else return Action.HOP;
        }
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() != Neighbor.WALL && info.getFront() != Neighbor.SAME){

            return Action.HOP;
        } else{
            return Action.RIGHT;
        }
    }

    private Action inCorner(CritterInfo info){
        if (!armed) {
            if ((info.getBack() == Neighbor.WALL || info.getBack() == Neighbor.SAME) && info.getDirection() == Direction.EAST) {
                armed = true;
                return Action.LEFT;
            }
            if ((info.getBack() == Neighbor.WALL || info.getBack() == Neighbor.SAME) && info.getDirection() == Direction.NORTH) {
                armed = true;
                return Action.RIGHT;
            }
        }else{
            if(info.getDirection() == Direction.NORTH){
                return Action.RIGHT;
            }else if (info.getDirection() == Direction.EAST){return Action.LEFT;}
            else return Action.RIGHT;
        }

        return Action.INFECT;

    }

    public Color getColor() {
        return Color.ORANGE;
    }

    public String toString() {
        return "M";
    }

}
