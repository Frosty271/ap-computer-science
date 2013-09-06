import java.util.Arrays;
import java.util.List;

//Nick Walker
public class Main {

    public static void main(String[] args) {
        System.out.println("Text Lab 01, 100 Point Version\n\n");
        System.out.println("Measure today's knowledge by yesterdays's confusion.\n");
        System.out.println("Bewilderment + Exposure = Obvious\n");
		String tempArray[] = new String[] { "1", "0", "1","1","1","1","1","0","1","1","1","1","1","0","0","0","0","1","1","1","1","1","0","1","1","1","1","1","0","1","0","1","0","0","0","1","0","1","1","1","1","1","0","1","1","1","1","1","2" };
		List<String> lineOne = Arrays.asList(tempArray);
		//Can't believe it's this complicated to initiate an array in Java. And it's not even an array of Integer Objects, either, so we're forced to cast them and unbox them. Ridiculous.
        printLine(lineOne);

		tempArray = new String[] { "1", "0", "1","0","0","0","1","0","1","0","0","0","1","0","0","0","0","1","0","0","0","1","0","1","0","0","0","1","0","1","0","1","1","0","0","1","0","0","0","1","0","0","0","1","0","0","0","0","2" };
		List<String> lineTwo = Arrays.asList(tempArray);
		printLine(lineTwo);

		tempArray = new String[] { "1", "0", "1","0","0","0","1","0","1","0","0","0","1","0","0","0","0","1","1","1","1","1","0","1","0","0","0","1","0","1","0","1","0","1","0","1","0","0","0","1","0","0","0","1","1","1","1","1","2" };
		List<String> lineThree = Arrays.asList(tempArray);
		printLine(lineThree);

		tempArray = new String[] { "1", "0", "1","0","0","0","1","0","1","0","0","0","1","0","0","0","0","1","0","0","0","0","0","1","0","0","0","1","0","1","0","1","0","0","1","1","0","0","0","1","0","0","0","0","0","0","0","1","2" };
		List<String> lineFour = Arrays.asList(tempArray);
		printLine(lineFour);

		tempArray = new String[] { "1", "0", "1","1","1","1","1","0","1","1","1","1","1","0","0","0","0","1","0","0","0","0","0","1","1","1","1","1","0","1","0","1","0","0","0","1","0","0","0","1","0","0","0","1","1","1","1","1","2" };
		List<String> lineFive = Arrays.asList(tempArray);
		printLine(lineFive);
    }
	public static void printLine(List<String> line){
		//Spliting this out is naturally much more extensible. So, if we ever need to build an ASCII art class, this is it in a primitive state. I could imagine wiring it up to read lines from a greyscale bmp and translating intensity into different characters.
		for(String pixel: line)
			switch (Integer.parseInt(pixel)) {
				case 1:
					System.out.print("\u0023");
					break;
				case 0:
					System.out.print(" ");
					break;
				case 2:
					System.out.print("\n");
					//This reminds me of nil termination in objective C back before the compiler started taking care of that.
					break;
			}
	}
}
