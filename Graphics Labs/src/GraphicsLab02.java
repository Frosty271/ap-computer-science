import java.awt.*;
import java.applet.*;
import java.util.ArrayList;

public class GraphicsLab02 extends Applet {
    public void paint(Graphics g)
    {
        // DRAW Parabola
     /*   ParabolaRectangle big = new ParabolaRectangle(0,0,800,600,20);
        big.draw(g);

        ParabolaRectangle medium = new ParabolaRectangle(200,150,400,300,20);
        medium.draw(g);

        ParabolaRectangle small = new ParabolaRectangle(300,225,200,150,20);
        small.draw(g);*/

		int baseWidth = 800,  baseHeight = 600,  baseIterations = 20;
		int rectangleIterations = 5;

		//Meta for-looping
		int tempWidth, tempHeight,tempXOrigin,tempYOrigin, tempIterations;
		ParabolaRectangle tempRectangle;
		//ArrayList rectangleList = new ArrayList<ParabolaRectangle>();
		for (int i = 0; i<=4; i++){
			tempHeight = (int)(baseHeight* Math.pow(.5,i));
			tempWidth = (int)(baseWidth* Math.pow(.5,i));
			tempXOrigin = ( (baseWidth-tempWidth)/2);
			tempYOrigin = ( (baseHeight-tempHeight)/2);
			//tempIterations =  (int) (baseIterations* Math.pow(.5,i) );
			tempIterations = baseIterations;
			tempRectangle = new ParabolaRectangle(tempXOrigin,tempYOrigin, tempWidth, tempHeight, tempIterations);
			tempRectangle.draw(g);
		}
    }
}
    class ParabolaRectangle{
        int xOrigin,yOrigin;
        int width, height;
        int iterations;

    public ParabolaRectangle(int xOrigin,int yOrigin,int width,int height, int iterations){
      this.xOrigin= xOrigin;
      this.yOrigin = yOrigin;
      this.width= width;
      this.height= height;
      this.iterations = iterations;
    }

    public void draw(Graphics g){
		//You'll get some unexpected results if you don't make your sizes evenly divisible by the iteration number.
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

