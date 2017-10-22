package book.exam;

import java.awt.*;

public class Bear extends Critter
{
    private boolean polar;
    private boolean turn;

    public Bear()
    {
        this.polar = polar;
        this.turn = true;
    }

    @Override
    public Action getMove(CritterInfo Info)
    {
        if(Info.frontThreat())
            return Action.INFECT;
        if(Neighbor.EMPTY == Info.getFront())
            return Action.HOP;
        else
            return Action.LEFT;
    }

    @Override
    public Color getColor()
    {
        if(polar)
            return Color.WHITE;
        else
            return Color.BLACK;
    }

    @Override
    public String toString()
    {
        turn = !turn;
        if(turn)
            return "(/)";
        else
            return "(\\)";
    }
}
