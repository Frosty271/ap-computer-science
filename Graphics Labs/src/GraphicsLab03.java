import java.awt.*;
import java.applet.*;
import java.util.ArrayList;

public class GraphicsLab03 extends Applet {
    public void paint(Graphics g)
    {
        int cellWidth = 390, cellHeight = 290;
        int padding = 5;

        int centerX = 2*padding+cellWidth, centerY = 2*padding+cellHeight;

        int totalHeight =2*centerY;
        int totalWidth = 2*centerX;
        g.drawRect(0,0,totalWidth,totalHeight);

        //

        //top down
        g.drawLine(centerX,0,centerX,totalHeight);

        //left to right
        g.drawLine(0,centerY,totalWidth,centerY);


        //Draw Lines
        for(int l = 0; l < 100; l++){
            g.setColor( new Color(random(255), random(255),random(255)));
            g.drawLine(10+random(385), 10+random(285), 10+random(385), 10+random(285));
        }
        int tempSquareSize;
        int startX, startY;
        for(int l = 0; l < 100; l++){
            g.setColor( new Color(random(255), random(255),random(255)));

            startX=400+random(335);
            startY = 10+random(235);
            tempSquareSize = 50;
            g.fillRect(startX, startY , tempSquareSize, tempSquareSize);
        }
        int tempCircleSize;
        for(int l = 0; l < 100; l++){
            g.setColor( new Color(random(255), random(255),random(255)));
            tempCircleSize = random(200);
            startX =10+random(385);
            startY = 300+random(285);
            startX = (startX+tempCircleSize > centerX) ? centerX-tempCircleSize : startX;

            startY = (startY+tempCircleSize > totalHeight) ? totalHeight-tempCircleSize : startY;

            g.drawOval(startX, startY, tempCircleSize, tempCircleSize);
        }
        g.setColor(Color.yellow);
        g.fillRect(550,350,100,100);
        g.setColor(Color.blue);
        //g.drawPolygon();
        g.setColor(Color.red);
        g.fillRect(600,400,100,100);
    }
   public int random(int cap){
       return  (int)(Math.random()*cap);
   }

 }

