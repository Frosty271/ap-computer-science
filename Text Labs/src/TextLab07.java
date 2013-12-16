import java.text.DecimalFormat;
import java.util.Scanner;

public class TextLab07 {

	public static void main(String args[]){

       System.out.println("Enter an odd number:");

       MagicSquare ourSquare = new MagicSquare(readInt());
         System.out.println(ourSquare);
         System.out.println(ourSquare.check());

    }
    public static int readInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();

    }
}

class MagicSquare {
    private final int size;
    private int[][] values;
    MagicSquare(){

        //Calls the constructor the other constructor. I've never seen syntax like this, but whatever
        this(7);
    }
    MagicSquare(int size){
        //size means number of positions in either dimensions
        this.size   = size;
        this.values = new int[this.size][this.size];

        //this.fancyFillSquare();
        this.fillSquare();
    }
    //The brute force method
    private void fillSquare(){
        //First row is at the top, first column at left
        //put a one in the top mid position
        final int topMid = this.size/2;
        final int maxExtent = this.size-1;
        values[0][(topMid)]= 1;


        int currentColumn =  (topMid), targetColumn = (topMid);
        int currentRow = 0, targetRow = 0;

        for( int i = 2; i<= Math.pow(size,2.0); i++)  {
            //First, let's shift our target up and to the right once. This means a negative row movement and a positive column movement
            targetRow--;
            targetColumn++;

            //System.out.println("Initial adj: " +targetRow +","+targetColumn);

            //Check if this puts us to the right of the grid, if so move us to the start again
            if(targetColumn> maxExtent) targetColumn=0;
            //check if we ended up above the grid, if so move down to the bottom
            if(targetRow< 0) targetRow= maxExtent;

            //System.out.println("Bounds adj: " +targetRow +","+targetColumn);

            //check if our target is occupied, if so we avert previous movements and simply go down
            if(this.values[targetRow][targetColumn] != 0){
                //System.out.println("Occupied:" + this.values[targetColumn][targetRow]);
                targetColumn = currentColumn;
                targetRow = currentRow;
                targetRow++;
            }

            //System.out.println("Target "+i+" : "+targetRow +","+targetColumn);

            //Fill 'er up. Then set new current position for the next cycle
            this.values[targetRow][targetColumn] = i;
            currentColumn = targetColumn;
            currentRow = targetRow;

            //System.out.println(this);
        }

    }
    //uses some fancyMath
    private void fancyFillSquare(){

        int currentColumn = 0, currentRow = 0;
        for (int[] column : this.values) {

            for (int row: column){
                //System.out.println("Target: " + currentRow + ", " + currentColumn);
                this.values[currentRow][currentColumn] = fancyMath(currentRow+1, currentColumn+1);
                currentColumn++;

            }
            currentColumn = 0;
            currentRow++;
            System.out.println(this);
        }

    }
    //Implementation of the mathematical algorithm
    //I bet this is faster too.
    private int fancyMath(int i, int j){
        //No, I don't know how this works. Google.
        final int n = this.size;
        int left = n * ((i + j - 1 + (n/2) ) % n );
        int right = ((i + (2*j) - 2) % n);
        return left + right + 1;
    }
    public String toString(){
        String returnString = this.size + " x " + this.size + " Magic Square \n=====\n";

        for (int[] row : this.values) returnString+= arrayToString(row, false) + "\n";

        return returnString;
    }
    //Check rows and columns
    public String check(){
        String returnString = "";

        returnString += "Checking Rows\n=====\n";
        for (int[] column : this.values) returnString += arrayToString(column, true);

        returnString += "\nChecking Columns\n=====\n";
        for(int i = 0; i < this.size; i++)  returnString += arrayToString(getColumnFrom2DArray(this.values, i), true);

        returnString += "\nChecking Diagonals\n=====\n";
        returnString += arrayToString(getBottomLeftDiagonal(this.values), true);
        returnString += arrayToString(getTopLeftDiagonal(this.values), true);

        return returnString;
    }
    //Because the builtin toString puts out junk we don't need. Has a check mode bit as well as well built in pretty formatting
    private String arrayToString(int[] array, boolean checkMode){
        String returnString = "";
        int currentColumn = 0;
        DecimalFormat formatter = new DecimalFormat("0000");
        for (int value: array){
            returnString += formatter.format(value);
            currentColumn++;
            if(checkMode && currentColumn != array.length) returnString+= "+";
            else returnString += " ";
        }

        if (checkMode) returnString += " = " + sumArray(array) + "\n";
        return returnString;
    }
    //These are methods that help pull things out arrays
    private int sumArray(int[] array){
        int tempSum = 0;
        for (int value: array) tempSum += value;
        return tempSum;
    }
    private int[] getColumnFrom2DArray(int[][] array, int desiredColumn){
        int[] returnColumn = new int[array.length];
        int index = 0;
        for(int[] row: array){
           returnColumn[index] = row[desiredColumn];
           index++;
        }
        return returnColumn;
    }
    private int[] getBottomLeftDiagonal(int[][] array) {
        //Fill coordinates 0,0 1,1 2,2 etc into a new array, where the origin is in the top left corner
        //I've included multiple redundant indices so that it's easier to see what exactly we're using it for at different places
        int[] returnArray = new int[array.length];
        int indexOfInsertion = 0;
        int indexOfRow = 0;
        int indexOfDesiredColumnValue = 0;
        for(int[] row: array){
            returnArray[indexOfInsertion] = row[indexOfDesiredColumnValue];
            indexOfRow++;
            indexOfInsertion++;
            indexOfDesiredColumnValue++;
        }
        return returnArray;
    }
    private int[] getTopLeftDiagonal(int[][] array) {
        //This gets 3, 3
        int[] returnArray = new int[array.length];

        int indexOfInsertion = array.length - 1;
        int indexOfRow = 0;
        int indexOfDesiredColumnValue = 0;
        for(int[] row: array){
            returnArray[indexOfInsertion] = row[indexOfDesiredColumnValue];
            indexOfRow++;
            indexOfInsertion--;
            indexOfDesiredColumnValue++;

        }
        return returnArray;
    }
}