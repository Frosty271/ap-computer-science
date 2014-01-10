import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;

public class GWLab04
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();

        world.add( new info.gridworld.actor.Bug());
        world.add( new Rock());
        world.add( new Actor());
        world.show();
    }
}
