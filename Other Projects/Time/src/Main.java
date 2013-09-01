import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		convert(read());
	}

	public static void convert(long inSeconds) {
		long days = inSeconds / 86400; //86400 seconds in a day. Any remainder is capped off by the data type.
		long hours = (inSeconds % 86400) / 3600; //We find the remainder once we've parsed out the days. Accordingly, the remainder of the operation can never be larger than 86399. We divide this remainder by the number of seconds in an hour to determine how many hours we have. Any remainder is truncated.
		long minutes = (inSeconds % 3600) / 60; //Very similar process
		long seconds = (inSeconds % 60);       //This time we need only find how many are left over after we parse out all of the the larger-than-59 blocks.

		System.out.print(days + " Days, " + hours + " Hours, " + minutes + " Minutes, " + seconds + " Seconds");
	}

	public static long read() {
		Scanner in = new Scanner(System.in);
		return in.nextLong();

	}
}
