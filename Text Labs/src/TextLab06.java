import java.util.ArrayList;
import java.util.Scanner;

public class TextLab06 {
	public static void main(String args[]){

		System.out.println("Enter a maximum number:");
		System.out.println(PrimeHelper.listPrimesUpTo(readInt()));

		System.out.println();

	}

    public static int readInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();

    }
}

class PrimeHelper{
     PrimeHelper(){
         //AKA don't instantiate me, AKA static class in Java
         throw new IllegalArgumentException();
     }

	public static boolean isPrime(Integer input)        {
		double cap = Math.sqrt( (double)input );

		//If the square root is a whole number, it's not prime.
		if( cap % 1 == 0 ) return false;
		for (int i = 2; i < cap; i++) {
			if( input % i == 0 ) return false;
			if( (input == i) || input == i-1 ) return false;
		}
		return true;
	}
    public static ArrayList<Integer> listPrimesUpTo(double max)        {
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        //Iterate over every number under our cap
        for (int i = 2; i < max; i++)
			if(isPrime(i)) primeList.add(i);
        return primeList;
    }

}
