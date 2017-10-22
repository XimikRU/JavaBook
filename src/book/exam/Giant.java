package book.exam;

import java.awt.*;

public class Giant extends Critter
{
    public static int steps = 0;
    private boolean changeName = true;

    public Giant()
    {
    }

    @Override
    public Action getMove(CritterInfo info)
    {
        if(steps++ == 6)
            changeName = !changeName;
        if(info.frontThreat())
            return Action.INFECT;
        if(info.getFront() == Neighbor.EMPTY)
            return Action.HOP;
        else
            return Action.RIGHT;
    }

    @Override
    public Color getColor()
    {
        return Color.GRAY;
    }

    @Override
    public String toString()
    {
        if(changeName)
            return "fee";
        else
            return "foe";
    }
}
