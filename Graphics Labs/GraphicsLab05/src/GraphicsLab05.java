import java.awt.*;
import java.applet.*;
import java.util.*;

enum ColorChannel{
	RED,
	GREEN,
	BLUE
}
public class GraphicsLab05 extends Applet
{
	public void paint(Graphics g)
	{
		int circleCount = 120;
		Shapes circles = new Shapes(g,circleCount);
	}
}


class Shapes
{
	private int circleCount;

	private int redCount, greenCount, blueCount;

	public Shapes(Graphics g,int c)
	{
		circleCount = c;
		redCount = 1;
		greenCount = 1;
		blueCount = 1;
		drawSquares(g);
		for (int k = 1; k <= circleCount; k++)
			drawRandomCircle(g);


	}
	public void drawSquares(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(10,100,30,30);
		g.setColor(Color.green);
		g.fillRect(10,250,30,30);
		g.setColor(Color.blue);
		g.fillRect(10,400,30,30);
	}

	public void drawRandomCircle(Graphics g)
	{
		int row = 0;
	   Color randomColor = this.getRandomColor();
		g.setColor(randomColor);
		switch (determineDominantChannel(randomColor)){
			case RED:
				row =  (int) Math.floor(redCount/17);
				g.fillOval(10+50*redCount-(row*50*17),100+50*row,30,30);
				this.redCount++;
				break;
			case GREEN:
				row =  (int) Math.floor(greenCount/17);
				g.fillOval(10+50*greenCount-(row*50*17),250+50*row,30,30);
				this.greenCount++;
				break;                                                                               .

			case BLUE:
				row =  (int) Math.floor(blueCount/17);
				g.fillOval(10+50*blueCount-(row*50*17),400+50*row,30,30);
				this.blueCount++;
				break;
		}
	}

	private Color getRandomColor()
	{
		return new Color((int) (Math.random()*256),(int) (Math.random()*256),(int) (Math.random()*256));
	}
	private ColorChannel determineDominantChannel(Color color){
	    int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();

		if(r>g && r>b) return ColorChannel.RED;
		if(b>g && b>r) return ColorChannel.BLUE;
		else return ColorChannel.GREEN;

}
}