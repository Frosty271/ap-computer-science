import java.awt.*;
import java.applet.*;
import java.util.ArrayList;

public class GraphicsLab03 extends Applet {
    public void paint(Graphics g)
    {
        //Settings
        int cellWidth = 390, cellHeight = 290;

        int centerX = cellWidth, centerY = cellHeight;

        int totalHeight =2*centerY;
        int totalWidth = 2*centerX;
        g.drawRect(0,0,totalWidth,totalHeight);

        //top down
        g.drawLine(centerX,0,centerX,totalHeight);

        //left to right
        g.drawLine(0,centerY,totalWidth,centerY);

        //Draw Lines
        for(int l = 0; l < 100; l++){
            g.setColor( new Color(random(255), random(255),random(255)));
            int maxX= centerX;
            int maxY= centerY;
            g.drawLine(random(maxX), random(maxY), random(maxX), random(maxY));
        }

        int squareSize = 50;
        int startX, startY;
        for(int l = 0; l < 100; l++){
            g.setColor( new Color(random(255), random(255),random(255)));

            int maxX= totalWidth-centerX-squareSize;
            int maxY= cellHeight;

            startX= centerX+random(maxX);
            startY = random(maxY-squareSize);

            g.fillRect(startX, startY , squareSize, squareSize);
        }

        int tempCircleSize;
        for(int l = 0; l < 100; l++){
            g.setColor( new Color(random(255), random(255),random(255)));
            tempCircleSize = random(200);

            startX = random(cellWidth);
            startY = centerY+random(cellHeight);

            while(startX+tempCircleSize > centerX) startX= random(cellWidth);
            while(startY+tempCircleSize > totalHeight) startY = centerY+random(cellHeight);
            //This method preserves randomness by regenerating random numbers until they fit our needs

            //startX = (startX+tempCircleSize > centerX) ? centerX-tempCircleSize : startX;
            //startY = (startY+tempCircleSize > totalHeight) ? totalHeight-tempCircleSize : startY;
            //Doing this just compresses the distribution of the circles to fit within the sides (not really random looking)

            g.drawOval(startX, startY, tempCircleSize, tempCircleSize);
        }
        g.setColor(Color.yellow);
        int cubeXOrigin = 500;
        int cubeYOrigin= 350;
        int cubeSize = 100;
        int cubeOffset = 50;
        g.fillRect(cubeXOrigin,cubeYOrigin,cubeSize,cubeSize);

        g.setColor(Color.green);
        int[] x ={cubeXOrigin, cubeXOrigin+cubeOffset,cubeXOrigin+cubeOffset,cubeXOrigin, cubeXOrigin};
        int[] y = {cubeYOrigin,cubeYOrigin+cubeOffset,cubeYOrigin+cubeOffset+cubeSize,cubeYOrigin+cubeSize,cubeYOrigin};
        g.fillPolygon(x,y, y.length);

        g.setColor(Color.blue);
        int[] x1 ={cubeXOrigin+cubeSize, cubeXOrigin+cubeOffset+cubeSize,cubeXOrigin+cubeOffset+cubeSize,cubeXOrigin+cubeSize, cubeXOrigin+cubeSize};
        int[] y1 = {cubeYOrigin,cubeYOrigin+cubeOffset,cubeYOrigin+cubeOffset+cubeSize,cubeYOrigin+cubeSize,cubeYOrigin};
        g.fillPolygon(x1,y1, y.length);

        g.setColor(Color.red);
        g.fillRect(cubeXOrigin+cubeOffset,cubeYOrigin +cubeOffset,cubeSize,cubeSize);
    }
   public int random(int cap){
       return  (int)(Math.random()*cap);
   }

 }

