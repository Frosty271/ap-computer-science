import info.gridworld.actor.ActorWorld;

public class GLab07
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        RandomActor actor = new RandomActor();
        world.add(actor);
        world.show();
    }
}
