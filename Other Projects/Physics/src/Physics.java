import java.util.Scanner;
public class Physics {
	public static void main(String args[]){

		System.out.println("Enter in a task:");
		System.out.println("a = dosomething");
		System.out.println("b = dosomethingelse");
		String task = readString();
		switch (task){
			case ("a"): //doSomething();
				break;
			case("b"): //doSomethingElse();
				break;
			default: System.out.println("Not a valid task");
		}
		System.out.println("Enter an initial velocity:");
		int initialVelocity = readInt();
		System.out.println("Enter an angle:");
		int angle = readInt();
		System.out.println( "Flight time : " + timeProjectileHitsGround(angle, initialVelocity ) + "s");
		System.out.println(horizontalDistanceProjectileTravels(angle, initialVelocity ) );
		System.out.println(maxProjectileHeight(angle, initialVelocity ) );
	}
	public static int readInt() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();

	}
	public static String readString() {
		Scanner in = new Scanner(System.in);
		return in.next();

	}
	public static double timeProjectileHitsGround(int theta, int v){
		double vy = Math.sin(Math.toRadians(theta)) * v;
		double t;
		for(t = 0.0001; heightOfFreefall(vy, t)> 0; t+= .001 );
		return t;
	}
	public static double horizontalDistanceProjectileTravels(int theta, int v){
		double vx = Math.cos(Math.toRadians(theta)) * v;
		return vx * timeProjectileHitsGround(theta, v);
	}
	public static double maxProjectileHeight(int theta, int v){
		double vy = Math.sin(Math.toRadians(theta)) * v;
		return heightOfFreefall(vy, horizontalDistanceProjectileTravels(theta, v)*.5);
	}
	public static double heightOfFreefall(double vy, double t){
		    return (t*vy) - .5 * 9.8 * Math.pow(t, 2);
	}
}