import java.util.ArrayList;

public class TextLab08
{
    public static void main(String args[])
    {
        System.out.println("\nTextLab08 STUDENT VERSION\n");

        Matrix m1 = new Matrix();
        System.out.println(m1);

        Matrix m2 = new Matrix(3,5);
        System.out.println("Matrix m2 3 X 5 Display");
        System.out.println(m2);
        int count = 100;
        for (int r = 0; r < m2.getRows(); r++)
        {
            for (int c = 0; c < m2.getCols(); c++)
            {
                m2.setValue(r,c,count);
                count++;
            }
        }
        System.out.println("Matrix m2 3 X 5 Consecutive Integers Display");
        System.out.println(m2);

        m2.resize(2,2);
        System.out.println("Matrix m2 After 4 X 4 Resizing Display");
        System.out.println(m2);

        Matrix m3 = new Matrix(3,3,100);
        System.out.println("Matrix m3 3 X 3 Initialized to 100 Display");
        System.out.println(m3);
    }

}


//Wrapper for a 2d Arraylist
class Matrix
{

    private ArrayList< ArrayList<Integer> > list;		//


    /**  Constructs empty ArrayList object and sets all values to 0  **/
    public Matrix(){
        this.list = new ArrayList< ArrayList<Integer> >();
    }

    /**  Constructs r X c matrix with all elements initialized to 0  **/
    public Matrix(int r, int c){
        this(r, c, 0);

    }

    /** Constructs r X c matrix will all elements initialized to value  **/
    public Matrix(int r, int c, int value){
        this.list = new ArrayList< ArrayList<Integer> >();
        for( int i = 0; i < r; i++ ){
            this.list.add(new ArrayList<Integer>());
            for( int j = 0; j < c; j++) this.list.get(i).add(value);
        }
    }

    /**  Returns numRows value  **/
    public int getRows(){
        return this.list.size();
    }

    /**  Returns numCols value  **/
    public int getCols() {
        return this.list.get(0).size();
    }

    /**  Returns listSize value  **/
    public int getSize(){
        return this.list.get(0).size() * this.list.get(0).size();
    }

    /**  Returns Matrix object value at (r,c) location  **/
    public int getValue(int r, int c)  {
        return this.list.get(r).get(c);
    }

    /**  Alters Matrix object value at (r,c) to value  **/
    public void setValue(int r, int c, int value) {
        this.list.get(r).set(c, value);
    }

    /**  Displays Matrix object in two-dimensional matrix format  **/
    public String toString() {
        String returnString = "";
        for(ArrayList<Integer> row: this.list){
            for(Integer value: row){ returnString += value + " ";  }
            returnString += "\n";
        }
        return returnString;
    }

    /**  Resizes Matrix object to new rows X cols size, copies all possible
     previous values and initializes new elements to zero  **/
    public void resize(int targetRows, int targetCols){
        int startRows = this.list.size();
        int startCols = this.list.get(0).size();
        if(targetRows > startRows){
            for(int i = 0; i < targetRows - startRows; i++) this.list.add(new ArrayList<Integer>(targetCols));
            }
        //This can be refactored so that the index is the current row position. Might be more clear.
        else if (targetRows < startRows){
            for(int r = startRows; r > targetRows; r--) this.list.remove(r-1);
        }
        if (targetCols > startCols)     {
            for(ArrayList<Integer> row: this.list){
                int initialRowSize = row.size();
                for(int i = 0; i < targetCols-initialRowSize; i++) row.add(0);
            }
        }
        //It occurs to me that one might write the conditional to simply be, if not
        else if (targetCols < startCols){
            for(ArrayList<Integer> row: this.list){
                int initialRowSize = row.size();
                for(int c = initialRowSize; c > targetCols; c--) row.remove(c-1);
            }
        }
        }
}
