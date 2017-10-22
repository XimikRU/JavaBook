package book.exam;

import java.awt.*;
import java.util.Random;

public class Tiger extends Critter
{
    public static int steps = 0;

    public Tiger()
    {

    }

    @Override
    public Action getMove(CritterInfo info)
    {
        steps++;
        if(info.frontThreat())
            return Action.INFECT;
        if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL)
            return Action.LEFT;
        if(info.getFront() == Neighbor.SAME)
            return Action.RIGHT;
        else
            return Action.HOP;
    }

    @Override
    public Color getColor()
    {
        if(steps % 3 == 0)
            return Color.RED;
        if(steps % 6 == 0)
            return Color.GREEN;
        else
            return Color.BLUE;
    }

    @Override
    public String toString()
    {
        return "TGR";
    }
}
