/*import java.util.Scanner;

public class TextLab05 {
	static int num1, den1, num2, den2;
	public static void main(String args[]){

		enterData();

		Rational r1 = new Rational(num1,den1);
		Rational r2 = new Rational(num2,den2);
		System.out.println(r1);

		Rational result = RationalHelper.multiply(r1,r2);

		System.out.println("\n\n" + r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + result.getRational());

		result = RationalHelper.divide(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + result.getRational());


		result = RationalHelper.add(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + result.getRational());

		result = RationalHelper.subtract(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + result.getRational());

		System.out.println();


	}



	public static void enterData()
	{

		System.out.print("\nEnter the 1st numerator ----> ");
		num1 = readInt();
		System.out.print("\nEnter the 1st denominator --> ");
		den1 = readInt();
		System.out.print("\nEnter the 2nd numerator ----> ");
		num2 = readInt();
		System.out.print("\nEnter the 2nd denominator --> ");
		den2 = readInt();
	}

	public static int readInt() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();

	}

}

//Immutable, provides multiple representations publicly
class Rational
{
	private final int num, den, reducedDen, reducedNum;
	Rational()
	{
		num = den = reducedDen = reducedNum = 1;
	}
	Rational(int num, int den){
		this.num = num;
		this.den = den;
        int gcf = getGCF(num, den);
        this.reducedDen = this.den / gcf;
        this.reducedNum = this.num / gcf;
	}
	public double getDecimal(){
		return (double)num/den;
	}

	public String getOriginal(){
		return reducedNum + "/" + reducedDen;
	}

	//returns a reduced representation
	public String getRational(){

		return reducedNum + "/" + reducedDen;
	}

	public int getNum()
	{
		return num;
	}

	public int getDen()
	{
		return den;
	}

	//Dumps all representations
	public String toString()
	{
		String returnString = getOriginal() + " equals " + getDecimal();
		returnString += "\n\n and reduces to " + getRational();
		return returnString;
	}

	private int getGCF(int a,int b)
	{
		if (b==0) return a;
		return getGCF(b,a%b);
		//Euclid's GCD algorithm.
		//This is kind of magical. I don't know exactly why this works.
	}


}

//Handles math with Rational objects
class RationalHelperx {

	//don't worry about reducing the fraction, that can be handled within the Rational object
	public static Rational multiply(Rational r1, Rational r2)
	{
		//Crossmultiply
		int newDen = r1.getDen() * r2.getDen();
		int newNum = r2.getNum()  * r1.getNum();

		return new Rational(newNum, newDen);

	}

	public static Rational divide(Rational r1, Rational r2)
	{
		//Flip the second and multiply
		int newDen = r1.getDen() * r2.getNum();
		int newNum = r1.getNum() * r2.getDen();

		return new Rational(newNum, newDen);

	}

	public static Rational add(Rational r1, Rational r2)
	{
		//Cross multiply and add
		int newDen = r1.getDen() * r2.getDen();
		int newNum = r1.getDen() * r2.getNum() + r2.getDen() * r1.getNum();

		return new Rational(newNum, newDen);

	}

	public static Rational subtract(Rational r1, Rational r2)
	{
		//crossmultiply and subtract
		int newDen = r1.getDen() * r2.getDen();
		int newNum = (r2.getDen() * r1.getNum()) - (r1.getDen() * r2.getNum());

		return new Rational(newNum, newDen);
		//return add(r1,multiply(-1,r2);
	}

}            */