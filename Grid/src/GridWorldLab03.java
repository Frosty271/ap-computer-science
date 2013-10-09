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

			runner.turn();
			runner.turn();  //We must turn atleast twice. Reaching the top facing north requires it so we can end up facing east
			//Odd columns require us to make 4 additional turns so we can face east  because we arrive facing south
			if( isOddColumn){
				runner.turn();
				runner.turn();
				runner.turn();
				runner.turn(); //This is silly. Should just add a new method on Bug that takes desired destination orientation.
			}

			runner.move();  //Step into the new column. Color hasn't changed at this point. This is the last flower set down in the column. This movement always occurs in the easterly direction

			runner.turn();
			runner.turn();//Must turn atleast twice to face south if we arrived facing east.

			//In an odd column, we want to end facing north in the new column, so we must turn from east to north. The 2 above plus four more turns.
			if( isOddColumn){
				runner.turn();
				runner.turn();
				runner.turn();
				runner.turn();
			}

			if( isOddColumn) runner.setColor(Color.red);
			else runner.setColor(Color.blue);

		}
		world.show(); //Now punt this state to the display
	}

}
