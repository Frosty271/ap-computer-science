import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Integer input = read();
		if( isPrime(input) ) System.out.print( input.toString() + " is prime." );
		else System.out.print( input.toString() + " isn't prime." );
	}
	public static boolean isPrime(Integer input)	{
		double cap = Math.sqrt( (double)input );
		if( cap % 1 == 0 ) return false;
		List<Integer> list = listPrimes( cap );
		//System.out.print( list);
		for(int i = 0; i < list.size(); i++){
			if ( (input % list.get(i) ) == 0 ){
				return false;
			}
		}
		return true;
	}
	public static List listPrimes(double cap)	{
		List<Integer> primeList = new ArrayList<Integer>();
		//Iterate over every number under our cap
		for (int i = 2; i < cap; i++) {
			for(int x=2; x <= i; x++){
				if( (x == i) || x == i-1 )	{
					primeList.add(i);
					break;
				}
				if( i%x == 0 ){
					break;
				}
			}

		}
		return primeList;
	}
	public static Integer read(){
		Scanner in = new Scanner(System.in);
		return in.nextInt();


	}
}