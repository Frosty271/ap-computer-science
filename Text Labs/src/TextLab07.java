import java.text.DecimalFormat;
import java.util.Scanner;

public class TextLab07 {

	public static void main(String args[]){

       MagicSquare ourSquare = new MagicSquare(3);
         System.out.println(ourSquare);
         System.out.println(ourSquare.check());

    }
}

//   0 1 2 3 4 5
// 0
// 1
// 2
// 3
// 4
// 5
//
class MagicSquare {
    private final int size;
    private int[][] values;
    MagicSquare(){
        //I've never seen syntax like this, but whatever
        this(7);
    }
    MagicSquare(int size){
        //size means number of positions in either dimensions
        this.size   = size;
        this.values = new int[this.size][this.size];

        //this.fancyFillSquare();
        this.fillSquare();
    }
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
    private void fancyFillSquare(){
        //implementation of the standard mathematical algorithm
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
    private int fancyMath(int i, int j){
        //No, I don't know how this works. Google.
        final int n = this.size;
        int left = n * ((i + j - 1 + (n/2) ) % n );
        int right = ((i + (2*j) - 2) % n);
        return left + right + 1;
    }
    public String toString(){
        DecimalFormat formatter = new DecimalFormat("0000");
        String returnString = "";

        for (int[] column : this.values) {

            for (int row: column) returnString += " "+formatter.format(row);
            returnString+= "\n";
        }
         return returnString;
    }
    //Check rows and columns
    public String check(){
        //This is ridiculous, need a better way to do this.
        //Maybe loops that put the values in a temp array, then a sperate method sums the array?
        DecimalFormat formatter = new DecimalFormat("0000");
        String returnString = "";
        int tempSum = 0;
        int currentColumn = 0;
        //Sum of rows
        for (int[] column : this.values) {

            for (int row: column){
                returnString += formatter.format(row);
                currentColumn++;
                if(currentColumn != this.size) returnString+= "+";
                tempSum += row;
            }
            currentColumn = 0;
            returnString += " = " + tempSum + "\n";
            tempSum = 0;
        }

        int tempValue;
        for(int i = 0; i < this.size; i++ ){
            tempValue = this.values[(this.size-1)-i][i];
            tempSum+= tempValue;
            returnString += formatter.format(tempValue);
            if(i != this.size-1) returnString+= "+";
        }
        returnString += " = " + tempSum + "\n";
        tempSum = 0;

        for(int i = 0; i < this.size; i++ ){
            tempValue = this.values[i][i];
            tempSum+= tempValue;
            returnString += formatter.format(tempValue);
            if(i != this.size-1) returnString+= "+";
        }

        returnString += " = " + tempSum + "\n";
        tempSum = 0;

        return returnString;
    }
}