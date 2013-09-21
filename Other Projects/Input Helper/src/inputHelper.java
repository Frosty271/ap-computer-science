import java.util.Scanner;

public class inputHelper {

	public static void main(String[] args) {
		//Naturally, this is only for educational purposes. Each call will throw an exception if it recieves the wrong type of input
		System.out.println("Enter a long integer.");
		long inputLong = readLong();
		System.out.println("You entered: " + inputLong);

		System.out.println("Enter a string.");
		String inputString = readString();
		System.out.println("You entered: " + inputString);

		System.out.println("Enter a decimal number.");
		double inputDouble = readDouble();
		System.out.println("You entered: " + inputDouble);
	}

	public static long readLong() {
		Scanner in = new Scanner(System.in);
		return in.nextLong();

	}
	public static double readDouble() {
		Scanner in = new Scanner(System.in);
		return in.nextDouble();

	}
	public static String readString() {
		Scanner in = new Scanner(System.in);
		return in.next();

	}
}
