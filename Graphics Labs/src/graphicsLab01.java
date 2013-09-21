
import java.awt.*;
import java.applet.*;


public class graphicsLab01 extends Applet {
    public void paint(Graphics g)
    {
        // DRAW CUBE

        int cubeXOrigin = 10;
        int cubeYOrigin= 20;
        int cubeSize = 100;
        g.drawRect(cubeXOrigin,cubeYOrigin,cubeSize,cubeSize);


        int cubeOffset = 50;
        g.drawRect(cubeXOrigin+cubeOffset,cubeYOrigin +cubeOffset,cubeSize,cubeSize);
        //Isometric projections are crazy hard to implement, so this will just have to be by eye.

         //top
        g.drawLine(cubeXOrigin,cubeYOrigin,cubeXOrigin+cubeOffset,cubeYOrigin +cubeOffset);
        g.drawLine( (cubeXOrigin+cubeSize),cubeYOrigin,cubeXOrigin+cubeOffset+cubeSize,cubeYOrigin +cubeOffset);
        //bottom
        g.drawLine(cubeXOrigin,cubeYOrigin+cubeSize,cubeXOrigin+cubeOffset,cubeYOrigin +cubeOffset +cubeSize);
        g.drawLine(cubeXOrigin+cubeSize,cubeYOrigin+cubeSize,cubeXOrigin+cubeOffset+cubeSize,cubeYOrigin +cubeOffset +cubeSize);

        // DRAW SPHERE
        int sXOrigin = 300;
        int sYOrigin= 300;
        int sSize = 200;
        int sMidY = (int)(.5*sSize) + sYOrigin;
        int sMidX = (int)(.5*sSize) + sXOrigin;

        g.drawOval(sXOrigin,sYOrigin,sSize,sSize);


        double heightCoefficient  = .5;
        g.drawOval(sXOrigin, sMidY-(int)(.5*(sSize*heightCoefficient)),sSize,((int)(heightCoefficient*sSize)));
        heightCoefficient  = .75;
        g.drawOval(sXOrigin, sMidY-(int)(.5*(sSize*heightCoefficient)),sSize,((int)(heightCoefficient*sSize)));
        heightCoefficient  = .25;
        g.drawOval(sXOrigin, sMidY-(int)(.5*(sSize*heightCoefficient)),sSize,((int)(heightCoefficient*sSize)));
        double widthCoefficient  = .5;
        g.drawOval(sMidX-(int)(.5*(sSize*widthCoefficient)), sYOrigin,((int)(widthCoefficient*sSize)),sSize);

        widthCoefficient  = .25;
        g.drawOval(sMidX-(int)(.5*(sSize*widthCoefficient)), sYOrigin,((int)(widthCoefficient*sSize)),sSize);

        widthCoefficient  = .75;
        g.drawOval(sMidX-(int)(.5*(sSize*widthCoefficient)), sYOrigin,((int)(widthCoefficient*sSize)),sSize);


        // DRAW INSCRIBED/CIRCUMSCRIBED TRIANGLE




        // DRAW APCS




        // DRAW PACMEN FLOWER




    }
      public static void drawSphere(int sXOrigin,int sYOrigin,int sSize) {

      }
}
