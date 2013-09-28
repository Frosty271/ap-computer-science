public class fitter {
	public static void main (String[] args){
		runTests();

	}
	public static boolean fit(int small, int big, int goal) {

		int lengthRemaining = goal;
		int[] bigResults = filter(lengthRemaining, 5, big);
		//System.out.println("Useless bigs:" + bigResults[0]);
		lengthRemaining-= bigResults[1];

		int[] smallResults = filter(lengthRemaining, 1, small);
		//System.out.println("Useless smalls:" + smallResults[0]);
		lengthRemaining-= smallResults[1];

		if(lengthRemaining == 0) return true;
		return false;
	}
	public static int[] filter(int target, int size, int number){

		int multiplesContained = target/size;
		int numberToBeUsed = Math.min(multiplesContained, number);
		//System.out.println("Number used of size " + size + ":" + numberToBeUsed);

		int numberRemaining = number - numberToBeUsed;
		//System.out.println("Number remaining of size " + size + ":" + numberRemaining);

		int lengthAccomplished = numberToBeUsed * size;
		int[] tempReturn = {numberRemaining, lengthAccomplished};
		return tempReturn;
	}
	public static void runTests(){
		System.out.println( fit(3,1,8 ) );//True
		System.out.println( fit(3,1,9 ) );//False
		System.out.println(fit(3, 2, 10)); //true
		System.out.println(fit(3, 2, 8)); //true
		System.out.println(fit(3, 2, 9)); //false
		System.out.println(fit(6, 1, 11)); //true
		System.out.println(fit(6, 0, 11));  //false
		System.out.println(fit(1, 4, 11));  //true
		System.out.println(fit(0, 3, 10));  //true
		System.out.println(fit(1, 4, 12));  //false
		System.out.println(fit(3, 1, 7));  //true
		System.out.println(fit(1, 1, 7));  //false
		System.out.println(fit(2, 1, 7));  //true
		System.out.println(fit(7, 1, 11));  //true
		System.out.println(fit(7, 1, 8));  //true
		System.out.println(fit(7, 1, 13));  //false
		System.out.println(fit(43, 1, 46));  //true
		System.out.println(fit(40, 1, 46));  //false
		System.out.println(fit(40, 2, 47));  //true
		System.out.println(fit(40, 2, 50));  //true
		System.out.println(fit(40, 2, 52));  //false
		System.out.println(fit(22, 2, 33));  //false
		System.out.println(fit(0, 2, 10));  //true
		System.out.println(fit(1000000, 1000, 1000100));  //true
		System.out.println(fit(2, 1000000, 100003));  //false
		System.out.println(fit(20, 0, 19));  //true
		System.out.println(fit(20, 0, 21));  //false
		System.out.println(fit(20, 4, 51));  //false
		System.out.println(fit(20, 4, 39));  //true
	}
}
