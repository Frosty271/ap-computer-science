/*
 * AP(r) Computer Science GridWorld Case Study:
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *
 *
 ************************************************************************
 ***  Written 06-22-10 by Leon Schram
 ***  This file is used with APCS GridWorldLab07.
 ***  This is the student, starting file.
 ************************************************************************
 *
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.Random;


public class RandomActor extends Actor
{
    int rockCounter = 0;
    //The lab specification calls for an array of bools to keep track of the entire grid's state. That's really dumb. It's all held in the Grid singelton. We should just poll that.
    public void act()
    {

        Grid<Actor> gr = getGrid();
        if( rockCounter+1 >= gr.getNumCols()*gr.getNumRows() ){
                return;
        }

        Location currentLocation = this.getLocation();

        int c;
        int r;
        Location randomLocation;
        do{
           c = (int)(Math.random()* gr.getNumCols());
           r = (int)(Math.random()* gr.getNumRows());
           randomLocation = new Location(r,c);
        }   while (!canMove(randomLocation));

        if(gr.isValid(randomLocation)){
            moveTo(randomLocation);
            placeRock(currentLocation);
        }
        rockCounter++;
    }
    public boolean canMove(Location loc)
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        if (!gr.isValid(loc))
            return false;
        Actor occupant = gr.get(loc);
        return (occupant == null);
        // not ok to move onto anything but empty space
    }
    public void placeRock(Location loc)
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);
        gr.put(loc, new Rock(new Color(r,g,b)));
    }
}
