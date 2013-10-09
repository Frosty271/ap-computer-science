import java.awt.*;
import java.applet.*;
import java.util.ArrayList;

public class GraphicsLab02 extends Applet {
    public void paint(Graphics g)
    {
        //It can be quite interesting to study the effects of changing the aspect ratio
		//Change these to prime numbers and watch the beauty fall apart ;)
        int baseWidth = 800,  baseHeight = 600;
        int numberRectangles = 4;

        //Draw rectangles
        int tempWidth, tempHeight,tempXOrigin,tempYOrigin;
        ParabolaRectangle tempRectangle;

        for (int i = 0; i<=numberRectangles; i++){
            tempHeight = (int)(baseHeight* Math.pow(.5,i));//Divide height in half i times
            tempWidth = (int)(baseWidth* Math.pow(.5,i));//Divide width in half by i times
            tempXOrigin = ( (baseWidth-tempWidth)/2); //Find the difference in size, and distribute the difference between the two sides of the rectangle
            tempYOrigin = ( (baseHeight-tempHeight)/2);//ditto

            tempRectangle = new ParabolaRectangle(tempXOrigin,tempYOrigin, tempWidth, tempHeight);
            tempRectangle.draw(g);
        }
    }
}
class ParabolaRectangle{
    int xOrigin,yOrigin;
    int width, height;
    int iterations;

    public ParabolaRectangle(int xOrigin,int yOrigin,int width,int height){
        this.xOrigin= xOrigin;
        this.yOrigin = yOrigin;
        this.width= width;
        this.height= height;
        this.iterations = ( gcf(width,height) < 100) ? gcf(width,height): 100;
        //You'll get some unexpected results if you don't make your sizes evenly divisible by the iteration number. So we take the greatest number that works, unless it's bigger than 100 (which would be a lot of lines).
        //This merits more explanation. In order for our effect to work, the change in the x and y aspects of our line MUST be equal. Therefore, our if our number of iterations does not divide evenly into both sides...
        //W=5
        //H=6
        //i = 3
        //H portion movement per iteration 2;
        //W portion for iteration is 5/3 = 1.66 -> 1
        //After i+1 iterations (0 indexed) W has been 0 2 3 4 6
        //But H will be only 0 1 2 3 4 ! It'll be a pixel short
        //We can circumvent this by storing the dimensional deltas in decimal form, but really, we'll just see the effect appear in strange jumps that occur when the decimals breach the next integer. I would rather keep both feet in the whole-pixel philosophy and just pick numbers that will work.
    }
    public int gcf(int a, int b){
        if (b==0) return a;
        return gcf(b,a%b);
	//Euclid's GCD algorithm.
        //This is kind of magical. I don't know exactly why this works.
    }

    public void draw(Graphics g){

        int heightPortion = height/iterations;
        int widthPortion = width/iterations;

        int startX, startY;
        int endX, endY;
        //Top left
        for(int i = 0; i<=iterations; i++){
            startY=yOrigin+ height-(i*heightPortion); //Go up
            startX =xOrigin+ 0; //Always start on the left edge

            endY= yOrigin+ 0;   //Always end on the top edge
            endX =xOrigin+ (i*widthPortion); //Go right
            g.drawLine(startX,startY,endX,endY);
        }
        //Bottom Left
        for(int i = 0; i<=iterations; i++){
            startY=(i*heightPortion); //Go up
            startX =0; //Always start on the left edge

            endY= height;   //Always end on the bottom edge
            endX =(i*widthPortion); //Go right
            g.drawLine(xOrigin+ startX,yOrigin+startY,xOrigin+endX,yOrigin+endY);
        }
        //Top Right
        for(int i = 0; i<=iterations; i++){
            startY=(i*heightPortion); //Go up
            startX = width; //Always start on the right edge

            endY=0;   //Always end on the top edge
            endX = (i*widthPortion); //Go right

            g.drawLine(xOrigin+startX,yOrigin+startY,xOrigin+endX,yOrigin+endY);
        }
        //Bottom Right
        for(int i = 0; i<=iterations; i++){
            startY=yOrigin+(i*heightPortion); //Go up
            startX =xOrigin+ width; //Always start on the right edge

            endY=yOrigin+ height;   //Always end on the bottom edge
            endX =xOrigin+ width-(i*widthPortion); //Go left
            g.drawLine(startX,startY,endX,endY);
        }

    }
}
