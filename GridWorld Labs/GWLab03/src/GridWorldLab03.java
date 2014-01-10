import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.*;


public class GridWorldLab03
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();

		Bug runner = new Bug();

		world.add(new Location(9,0), runner);
		int columns = 9, rows = 9;
		boolean isOddColumn;
		for(int c=0; c<=columns; c++){
			isOddColumn = (c%2) == 1; //0 is even
			for (int r=0; r<rows; r++ ) runner.move(); //Move the # of rows required. This should also be a method on a custom Bug.
			if(c == columns) break; //If we've rearched the last column, leave the bug at the end as opposed to setting him up for the next iteration.

			runner.setDirection(90);  //Face east

			runner.move();  //Step into the new column. Color hasn't changed at this point. This is the last flower set down in the column. This movement always occurs in the easterly direction

			if( isOddColumn) runner.setDirection(0); // face north
			else runner.setDirection(180);// face south
			if( isOddColumn) runner.setColor(Color.red);
			else runner.setColor(Color.blue);

		}
		world.show(); //Now punt this state to the display
	}

}
