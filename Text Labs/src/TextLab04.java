import java.util.Scanner;

public class TextLab04 {
    static int num1, den1;
    public static void main(String args[]){

        enterData();

        Rational r1 = new Rational(num1,den1);
        System.out.println(r1);

    }

    public static void enterData()
    {

        System.out.print("\nEnter the 1st numerator ----> ");
        num1 = readInt();
        System.out.print("\nEnter the 1st denominator --> ");
        den1 = readInt();

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
        return num + "/" + den;
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
        returnString += "\n\nand reduces to " + getRational();
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