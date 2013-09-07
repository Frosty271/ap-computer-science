public class Main {

    public static void main(String[] args) {
		//Code is normally executed from top to bottom. Here are some ways we can skip, loop, and otherwise modify the flow of the program.

		//IF
		//The parentheses enclose an arbitrary statement which is then simplified into either 'true' or 'false.' If the statement is true, then the code in the curly braces runs.
		if(true){
			System.out.println("if condition was true.");
		}
		//False is not true, ergo the code will not run.
		if(false){
			System.out.println("This shouldn't appear in the console.");
		}

		//Mathematical expressions can be evaluated as true or false. Notice too that we can omit the curly braces if we only need to execute one line of code.
		if( 10 > 0 ) System.out.println("10 is indeed greater than 0.");

		//Notice that in order to compare one number to another, we must actually use two equals signs. This is because one equals sign is reserved for assigning values to variables.
		if( 10 == 10 ) System.out.println("10 is indeed 10");

		//Also note that we can nest parentheses arbitrarily
		if( (10*10)/10 == 10) System.out.println("10 after some multiplication and divison still equals 10.");

		//IF, ELSE, ELSE IF
		//If statements alone are not very powerful.
		//The else keyword lets us do something even when the if condition evaluates to false.
		if(false) System.out.println("This shouldn't appear in the console.");
		else System.out.println("This WILL appear.");

		//But what if want more than just two paths (one for true and one for false)? Else if lets us test multiple conditions in sequence until we find one that is true. Note that as soon as if finds one that IS true, it won't even bother to check the others, even if they are true too.
		if(false) System.out.println("This shouldn't appear in the console.");
		else if(true) System.out.println("This will appear.");
		else if(true) System.out.println("This WON'T appear.");

		//All together.
		if(false) System.out.println("Won't appear.");
		else if( 10 == 11 ) System.out.println("Won't appear.");
		else if(false) System.out.println("Nope.");
		else System.out.println("This will appear, because nothing above was true.");

    }
}
