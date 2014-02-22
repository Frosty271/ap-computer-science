import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TextLab06 {
	public static void main(String args[]){
		  SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
		  System.out.println("Enter the primes upper bound ===>>") ;
		  Long input = readLong();
		  System.out.println("COMPUTING PRIME NUMBERS");
		  for(long prime: sieveOfEratosthenes.primesUpTo(input)){
			  System.out.printf("%04d ",prime);
		  }

		  //testPrimenessWithAllStrategies(input);

	}
	//This won't turn out like you expect, probably because Math.sqrt is slower than we'd expect and division is just so fast
	public static void testPrimenessWithAllStrategies(long input) {

		System.out.println("Naive Division:");
		NaiveDivision naiveDivision = new NaiveDivision();
		PrimeStrategyBenchmarker naiveDivisionBencher = new PrimeStrategyBenchmarker(naiveDivision);
		naiveDivisionBencher.executeIsPrime(input);

		System.out.println("Smart Division:");
		SmartDivision smartDivision = new SmartDivision();
		PrimeStrategyBenchmarker smartDivisionBencher = new PrimeStrategyBenchmarker(smartDivision);
		smartDivisionBencher.executeIsPrime(input);

		System.out.println("Sieve of Eratosthenes:");
		SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
		PrimeStrategyBenchmarker sieveOfEratosthenesBencher = new PrimeStrategyBenchmarker(sieveOfEratosthenes);
		sieveOfEratosthenesBencher.executeIsPrime(input);

	}
	public static long readLong() {
		Scanner in = new Scanner(System.in);

		return in.nextLong();

	}
}

//STRATEGIES
interface PrimeStrategy {
	abstract boolean isPrime(Long input);
	ArrayList<Long> primesUpTo(long cap);
}
class SieveOfEratosthenes implements PrimeStrategy{
	public boolean isPrime(Long input)
	{
		ArrayList<Long> primes = primesUpTo(input);
		for (Long prime: primes) {
			if (input.equals(prime)) return true;
		}
		return false;
	}
	public ArrayList<Long> primesUpTo(long cap)        {
		//Array indices will limit our search range compared to other strategies.
		// all are initialized to false  (all are assumed prime)
		boolean[] composites = new boolean[(int)cap];

		for(int factor = 2; factor < cap; factor++){
				for(int i = factor*2; i < cap; i+=factor) composites[i]= true;
		}
		//Exceptions
		composites[0] = composites[1] = true;
		ArrayList<Long> primeList = new ArrayList<Long>();
		for (int i = 0; i < composites.length; i++) if(!composites[i]) primeList.add((long)i);

		return primeList;


	}
}
class SmartDivision implements PrimeStrategy{
	public boolean isPrime(Long input)
	{
		long cap = (long)Math.sqrt(input);
		for (long test = 2; test < cap; test++) {
			if ((input % test) == 0) return false;
		}
		return true;
	}
	public ArrayList<Long> primesUpTo(long cap)        {
		ArrayList<Long> primeList = new ArrayList<Long>();
		//Iterate over every number under our cap
		for (long i = 2; i < cap; i++) {
			if(isPrime(i)) primeList.add(i);
		}
		return primeList;


	}
}
class NaiveDivision implements PrimeStrategy{
	public boolean isPrime(Long input)        {
		for (long test = 2; test < input; test++) {
			if ((input % test) == 0) return false;
		}
		return true;
	}
	public ArrayList<Long> primesUpTo(long cap)        {
		ArrayList<Long> primeList = new ArrayList<Long>();
		//Iterate over every number under our cap
		for (long i = 2; i < cap; i++) {
			if(isPrime(i)) primeList.add(i);
		}
		return primeList;
	}

}
//Helpers
class PrimeStrategyBenchmarker {
	private PrimeStrategy strategy;
	private String timeFormat = "%5.5fms %n";
	public PrimeStrategyBenchmarker(PrimeStrategy strategy) {
		this.strategy = strategy;
	}

	public boolean executeIsPrime(Long input) {
		ExecutionTimer.benchmark();
		boolean result = this.strategy.isPrime(input);
		System.out.printf(timeFormat, (double)ExecutionTimer.benchmark()/1000000);
		return result;
	}
	public ArrayList<Long> executePrimesUpTo(long cap) {

		ExecutionTimer.benchmark();
		ArrayList<Long> result = this.strategy.primesUpTo(cap);
		System.out.printf(timeFormat, (double)ExecutionTimer.benchmark()/1000000);
		return result;
	}
}
//Static class for ease of use.
class ExecutionTimer{
	ExecutionTimer(){
		//AKA don't instantiate me, AKA static class in Java
		throw new IllegalArgumentException();
	}
	static long lastBenchmark;
	static long benchmark(){
		long delta = 0;
		if (lastBenchmark == 0){
			lastBenchmark = System.nanoTime();
		}
		else {
			delta = System.nanoTime() - lastBenchmark;
			lastBenchmark = 0;
		}

		return delta;
	}
}