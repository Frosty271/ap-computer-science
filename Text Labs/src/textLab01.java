import java.util.Arrays;
import java.util.List;

//Nick Walker
public class TextLab01 {

    public static void main(String[] args) {
        System.out.println("Text Lab 01, 100 Point Version\n\n");
        System.out.println("Measure today's knowledge by yesterdays's confusion.\n");
        System.out.println("Bewilderment + Exposure = Obvious\n");
		int[] line={ 1, 0, 1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,1,1,2 };
        printLine(line);

		int[] lineTwo = { 1, 0, 1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,2 };
		printLine(lineTwo);

		int[] lineThree = { 1, 0, 1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,1,1,1,1,1,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1,1,1,1,1,2 };
		printLine(lineThree);

		int[] lineFour = { 1, 0, 1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0,1,2 };
		printLine(lineFour);

		int[] lineFive = { 1, 0, 1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,2 };
		printLine(lineFive);
    }
	public static void printLine(int[] line){
		//Spliting this out is naturally much more extensible. So, if we ever need to build an ASCII art class, this is it in a primitive state. I could imagine wiring it up to read lines from a greyscale bmp and translating intensity into different characters.
		for(int pixel: line)
			switch (pixel) {
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
