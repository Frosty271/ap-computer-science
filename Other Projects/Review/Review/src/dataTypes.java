import java.util.Arrays;
import java.util.List;

//Nick Walker
public class dataTypes {

    public static void main(String[] args) {
        //Unfortunately, you can't store arbitrary data in just any type of variable. Variables come in specific types. This is because the bytes in memory to record certain types of data are larger than others. Memory used to be important. It is less so now, but we still have data types as a built in protection against certain types of mistakes.
        //byte uses 1 byte
        //short uses 2 bytes
        //int uses 4 bytes
        //long uses 8 bytes


        //floats uses 4 bytes to keep decimal places
        //doubles uses 8 bytes keep decimals too
        //More bytes gives us more precision.

		//You don't really need to know about the low level memory mapping further than how to debug resultant problems as far as the AP test is concerned.

        //Ground Rules
        //Variables must be initialized before they are assigned.
        int variableName;

        //Variables are initialized by stating the datatype (int) then an arbitrary name (variableName). No two variables of the same type can have the same name. Once initialized, a name cannot be reinitialized, even as a different type.
		//double variableName; COMPILE ERROR

		//Variables can be assigned values with an equals sign.
        variableName = 10;

		//... and called upon by name anywhere beyond their assignment.

		System.out.println(variableName);

        //You can combine these tasks in one statement if you like.
        int a = 10;

		//Variables do have max values determined by the possible combinations of ones and zeroes allowed by their underlying memory allocation. 4 bytes yields 2^32 possible combinations of on and off states. 4 bytes = 32 bits. This should give you an idea about the whole 32 bit vs 64 bit architecture concept.

		//Incompatible data types will fail at compile time. Ints can't store decimal points.
		//int b = 3.0; COMPILE ERROR

		//MATH
		//Works like you would expect. PEMDAS applies. When in doubt, be explicit with operator orders. There's no penalty for nesting parentheses.

        //UNARY OPERATORS
        //Unary operators function on a single number or varaible.
        int x;
        //BINARY OPERATORS
        int unary = 1;
        //ASSIGNMENT OPERATORS
        x = 10;
        //Plus-equals. Adds 10 to the value held in x.
        x+=10;
        x = 10;
        x-=10;

        x = 10;
        x/=10;

        x%=10;
        System.out.println(unary++);
        System.out.println(unary++);

    }
}