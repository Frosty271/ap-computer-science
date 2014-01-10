import com.sun.javaws.exceptions.InvalidArgumentException;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class GWLab06A
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();

		Location[] locations =  { new Location(8,0), new Location(9,4), new Location(4,3), new Location(5,3), new Location(5,6), new Location(6,9), new Location(7,9), new Location(9,9), new Location(5,9) };
		Actor[] actors = {new Rock(),new Rock(),new Rock(),new Rock(),new Rock(),new Rock(),new Rock(),new Rock(),new Rock()};
		try{
			addArrayOfObjects(locations, actors, world);
		}
		catch(Exception error){System.out.println("Failed");}

		world.add(new Location(9,0),new Frog());
		world.add(new Location(9,6),new Frog(270));

		world.show();
	}
	private static void addArrayOfObjects( Location[] locations, Actor[] actors, ActorWorld world) throws Exception {
		//Weird syntax for throwing as part of signature
		if( locations.length != actors.length) throw new Exception("Error");
		//There are more precise exceptions but the require arguments and I don't want to dig through the Java docs right now
		for( int i = 0; i< locations.length; i++) world.add(locations[i],actors[i]);


	}
}