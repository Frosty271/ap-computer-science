public class dataTypes {

    public static void main(String[] args) {
        //Ground Rules
        //Variables must be initialized before they are assigned.
        int variableName;

        //Variables are initialized by stating the datatype (int) then an arbitrary name (variableName). No two variables of the same type can have the same name. Once initialized, a name cannot be reinitialized, even as a different type.
		//double variableName; COMPILE ERROR

		//Variables can be assigned values with an equals sign.
        variableName = 10;

		//... and called upon by name anywhere beyond their assignment.

		System.out.println(variableName); //It's the same as if you had just typed 10 straight into the print statement.

        //You can combine these tasks in one statement if you like.
        int a = 10;

		//A LITTLE ABOUT MEMORY
		//Unfortunately, you can't store arbitrary data in just any type of variable. If you try to put a letter in an int, it won't work. Variables come in specific types. This is because the number of bytes of memory required to record certain types of data is larger than others. Memory used to be important. It is less so now, but we still have data types (for a number of reasons that aren't too important; google 'programming data types' if you're curious). There are certain programming languages that don't even have types. Java is not one of them.

		//There are two different types of number data types. One allows a decimal point, one does not.

		//byte uses 1 byte
		//short uses 2 bytes
		//int uses 4 bytes
		//long uses 8 bytes

		//floats uses 4 bytes AND keep decimal places too
		//doubles uses 8 bytes AND keeps decimal places too

		//Incompatible data types will fail at compile time. Ints can't store decimal points!
		//int b = 3.0; COMPILE ERROR

		//Rule of thumb: More bytes gives us more precision. (The math for this: one bit is 2^1 possibilties, 4 bytes = 32 bits = 2^32 possibilities. That's A LOT of possible binary combinations.)
		//(This should also give you an idea about the whole 32 bit vs 64 bit architecture concept. That's an interesting thing to google.)

		//You don't really need to know about the low level memory mapping further than how to debug resultant problems as far as the AP test is concerned. You do need to know that variables of certain datatypes have max values determined by the possible combinations of ones and zeroes allowed by their underlying memory allocation. Don't try to store unreasonably large numbers in a small datatype or you will get unexpected behavior (NOT an error either, it will just fail silently and spew random numbers at you, which is a PITA to debug).


        //UNARY OPERATORS
        //Unary operators function on a single number or variable. There's not a whole lot you can do to one number in isolation. There are only two, increment and decrement. Mostly, you'll see these used as 'counters,' variables whose purpose is only to store the number of times something has been done.

        int c = 10;
		++c;  //Bumps the current value of c by one.
		System.out.println(c); //This should read eleven.
		--c;  //Takes the current value of c down by one.
		System.out.println(c);  //This should read ten.

		//The tricky part aspect of unary operators is what happens when you string them together. What the operators actually do is:
		// 1) Make the current value one more or one less
		// 2) Give the new current value as the value of the variable in the statement.
		// 3) Continue executing the line of code

		int d = 0;// d is zero.

		d = ++d + ++d;
	//  ^0   ^1    ^2   //Can you see how the first incrementation changes the value of d before the second incrementation?
		System.out.println(d); //This will actually read 3!

		//Interestingly, if you place the incrementation AFTER the varible, it flips the first and second step!
		int e = 0;
		System.out.println(++e); //This will read 1.
		System.out.println(e++); //This will read 1 too! The print statement gets the value of 1 BEFORE it's incremented. The value is still incremented though...
		System.out.println(e); //This will read 2 as per the above.

		//As you can imagine, this is pretty confusing, even to experienced programmers. It's dangerous to lose track of whether a variable gets incremented before or after it gets accessed and it can make for tough bugs. It's best to avoid using these operators for this reason.

        //BINARY OPERATORS
		//These are your more traditional math operators. It works like you would expect. PEMDAS applies. When in doubt, be explicit with operator orders. There's no penalty for nesting parentheses.
       int f = 10;
		System.out.println( (f + f) + ( (f*f)/f ) );   //Should read 30

        //ASSIGNMENT OPERATORS
		//The equals sign in programming-land is more correctly refered to as the 'assignment operator.' This is because it 'assigns' values to variables.
		int g;
        g = 10; //Ten is assigned to g

		//This is why when we do comparisons between variables, say, in an 'if' statement, we can't use the equals sign
		//if (g = 10){};  COMPILE ERROR: You can't assign a g a value in the if statement!
		if(g == 10){System.out.println("Hey, g was 10");} // Equality comparison operator is actually TWO equals signs.

		//We'll cover the other logical comparison operators later.

		//There are other basic assignment operators too.

		int h = 100;

        //Plus-equals. Add a value to the value of a variable.
        h+=10; //This is the same as h = h+10
		//Minus-equals. Subtract a value from the value of a variable.
	    h-=10; //Same as h = h-10

        h/=10; //Slash equals. Divide the variable value and store the result.

        h%=10; //Mod equals. Modulo devide the variable value and store the result.


		//WHERE MY WORDS AT?
		//Numbers are pretty straight forward. What about letters? Really, all you need to know is the 'String' type. It stores 'strings' of letters.

		String i = "Word."; //Just wrap some text in a pair of double quotes and you're good to go.
		System.out.println(i); //Simple, huh? (Also notice how the datatype here is capitalized... And how we aren't talking about exactly how much memory a string is allocated... We'll talk more about that later on. )

		//Whenever we've been printing things to the console, we've actually be using strings.
		System.out.println("I'm a string literal!"); //We call this type of string, which wasn't initialized as a variable first, a 'string literal.'
		// Single quotes WILL NOT WORK.
		//String j = 'Word.'; // COMPILE ERROR

		//What happens when you want to put strings together?
		String j = " What up?";
		System.out.println(i + j); //We can add strings? Well, no. When the compiler sees that we're using the plus operator on the strings, it knows that we actually want to put the strings together. This is called operator overloading.

		//THE WEIRD TYPE
		//More often than you might imagine, it's useful to just store a value that is either on or off. True or false. There's a type for that. It's called a boolean (after the logician that came up with this kind of 'on or off' thinking).
		boolean k = false; //Here, false IS NOT A STRING. There are no quotes around it. It's a special reserved keyword.
		System.out.println(k); //...yet this will print false into the console. I just said it wasn't a string, so how does that work? It's compiler magic.
		//Moral of the story is, don't try to use a boolean like you would a String or you'll run into problems.

		//You might recognize 'true or false' from control structures...
		boolean l = true;
		if(l) System.out.println("Boolean l was true, so the if statement ran!");
		//If statements run on boolean logic

		//SWITCHING BETWEEN TYPES
		//Placing a type name in parentheses before a variable name will translate it to the enclosed type. This is called 'typecasting'. Different translations work in different ways, so always be sure to test how it works before you start relying on it.
		double m = 10.2349508;
		int n = (int)m;
		System.out.println(n);

		//CONSTANTS
		//Sometimes you want variables to be less... variable. You can lock them with the final keyword.
		final int o = 10;
		//o = 20; COMPILE ERROR
		final int p;
		p =10;  //Accepts the first assignment...
		//p = 11;  COMPILE ERROR: Locks out further assignment.
    }
}