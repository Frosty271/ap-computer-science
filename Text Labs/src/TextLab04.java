import java.util.Scanner;

public class TextLab04 {
    static int num, den;
    public static void main(String args[]){
        System.out.print("\nEnter the numerator --> ");
        num = (int)readLong();
        System.out.print("\nEnter the denominator --> ");
        den = (int)readLong();

        Rational r = new Rational(num,den);

        r.displayData();

    }
    public static long readLong() {
        Scanner in = new Scanner(System.in);
        return in.nextLong();

    }

}
class Rational
{
    private final int num, den;
    Rational(int num, int den){
        this.num = num;
        this.den = den;
    }
    private double getDecimal(){
        return (double)num/den;
    }

	private String getOriginal(){
        return num + "/" + den;
    }

    private String getRational(){
        int gcf = getGCF(num, den);
        return num/gcf + "/" + den/gcf;
    }

//	reduce

    public void displayData()
    {
        System.out.println();
        System.out.println(getOriginal() + " equals " + getDecimal());
        System.out.println();
        System.out.println("and reduces to " + getRational());
        System.out.println();
    }

    private int getGCF(int a,int b)
    {
        if (b==0) return a;
        return getGCF(b,a%b);
        //Euclid's GCD algorithm.
        //This is kind of magical. I don't know exactly why this works.
    }
}
