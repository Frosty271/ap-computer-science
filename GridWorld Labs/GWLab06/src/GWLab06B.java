/*
 * 	@author Leon Schram 01-28-12
 * 	Lab06ATester.java
 * 	This is the driving file for the 80 Point Version of GridWorld Lab 06.
 *  This file is not to be altered.
 *  Students need to create a new CompassBug.java file
 */


import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


public class GWLab06B
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        CompassBug tom = new CompassBug(7);
        CompassBug jerry = new CompassBug(5);
        world.add(new Location(8,1),tom);
        world.add(new Location(7,2),jerry);
        world.show();
    }
}
