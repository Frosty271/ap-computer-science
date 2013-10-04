import java.util.Scanner;

public class TextLab02 {

	public static void main(String[] args) {
		System.out.println("Please enter a number of milliseconds.");
		convert(read());
	}

	public static void convert(long inMilliSeconds) {

		long days = inMilliSeconds / 86400000; //86400000 milliseconds in a day. Any remainder is capped off by the data type.

		long hours = (inMilliSeconds % 86400000) / 3600000; //We find the remainder once we've parsed out the days. Accordingly, the remainder of the operation can never be larger than 86399999. We divide this remainder by the number of seconds in an hour to determine how many hours we have. Any remainder is truncated.
		long minutes = (inMilliSeconds % 3600000) / 60000; //Very similar process
		long seconds = (inMilliSeconds % 60000) / 1000; //Filter out large blocks, divide up whats left.
		long milliSeconds = (inMilliSeconds % 1000 ); //This time we need only find how many are left over after we parse out all of the the larger-than-1000 blocks.
		//System.out.print(days + " Days, " + hours + " Hours, " + minutes + " Minutes, " + seconds + " Seconds");
		System.out.println ("Starting milli-seconds:" + inMilliSeconds );
		System.out.println ("Hours: " + hours );
		System.out.println ("Minutes: " + minutes );
		System.out.println ("Seconds: " + seconds );
		System.out.println ("Milli-Seconds: " + milliSeconds );
	}

	public static long read() {
		Scanner in = new Scanner(System.in);
		return in.nextLong();

	}
}
