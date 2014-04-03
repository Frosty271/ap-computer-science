import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
public class GraphicsLab06
{
	public static void main(String args[])
	{
		Windows win = new Windows();
		win.setSize(800,600);
		win.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);
			}
		});
		win.show();
	}
}
class Windows extends Frame
{

	public void paint(Graphics g)
	{
		ArrayList<AbstractShape> shapes = new ArrayList<AbstractShape>();
		int padding = 60;
		int windowHeight = 300;
		int windowWidth = 400;
		shapes.add(new Square(padding,padding,padding,windowHeight-padding));
		shapes.add(new Triangle(windowWidth+padding,padding,windowWidth+padding,windowHeight-padding));
		shapes.add(new Octagon(padding,padding+windowHeight,padding,windowHeight*2-padding));
		shapes.add(new Circle(windowWidth+padding,windowHeight+padding,windowWidth+padding,windowHeight*2-padding));

		drawGrid(g);

		for(AbstractShape shape: shapes)
		{
			shape.draw(g);
			shape.displayName(g);
			shape.displayDescription(g);
		}
	}

	public void drawGrid(Graphics g)
	{
		g.drawLine(0,300,800,300);
		g.drawLine(400,0,400,600);
	}
}
interface Drawable {
	/**
	 *
	 * @param g
	 */
	public void draw(Graphics g);
	public void displayName(Graphics g);
	public void displayDescription(Graphics g);
}

abstract class AbstractShape implements Drawable{
	int numSides;
	String shapeName = this.getClass().getName();
	int titleX, titleY;
	int messageX, messageY;

	/**
	 * All shapes will display a title and a message. Takes coordinates to place description and shapename string.
	 *
	 * @param titleX    The x value for the origin of the title string.
	 * @param titleY    The y value for the origin of the title string.
	 * @param messageX  The x value for the origin of the message string.
	 * @param messageY  The y value for the origin of the message string.
	 */
	public AbstractShape(int titleX, int titleY, int messageX, int messageY){
		this.titleX = titleX;
		this.titleY = titleY;
		this.messageX = messageX;
		this.messageY = messageY;
	}

	/**
	 * Displays the name of the class at a coordinate pair
	 *
	 * @param g Target graphics context
	 */
	public void displayName(Graphics g){
		g.drawString(this.shapeName, titleX, titleY);
	}

	/**
	 * Displays a text string describing the shape
	 *
	 * @param g Target graphics context
	 */
	public void displayDescription(Graphics g){
		g.drawString("A " + shapeName + " has " + numSides + " sides.", messageX, messageY);
	}
}
class Square extends AbstractShape {
	/**
	 * Constructs a foursided shape.
	 *
	 * @param titleX    The x value for the origin of the title string.
	 * @param titleY    The y value for the origin of the title string.
	 * @param messageX  The x value for the origin of the message string.
	 * @param messageY  The y value for the origin of the message string.
	 */
	public Square(int titleX, int titleY, int messageX, int messageY){
		super(titleX, titleY, messageX, messageY);
		this.numSides = 4;
	}
	public void draw(Graphics g){
		g.fillRect(100,100,100,100);
	}


}
class Triangle extends AbstractShape {
	/**
	 * Constructs a threesided shape.
	 *
	 * @param titleX    The x value for the origin of the title string.
	 * @param titleY    The y value for the origin of the title string.
	 * @param messageX  The x value for the origin of the message string.
	 * @param messageY  The y value for the origin of the message string.
	 */
	public Triangle(int titleX, int titleY, int messageX, int messageY){
		super(titleX, titleY, messageX, messageY);
		this.numSides = 3;
	}
	public void draw(Graphics g){
		g.fillPolygon(new int[] {500,600,550},new int[] {200,200,120},3);
	}

}
class Circle extends AbstractShape {
	/**
	 * Constructs a zerosided shape.
	 *
	 * @param titleX    The x value for the origin of the title string.
	 * @param titleY    The y value for the origin of the title string.
	 * @param messageX  The x value for the origin of the message string.
	 * @param messageY  The y value for the origin of the message string.
	 */
	public Circle(int titleX, int titleY, int messageX, int messageY){
		super(titleX, titleY, messageX, messageY);
		this.numSides = 0;
	}
	public void draw(Graphics g){
		g.fillOval(500, 400, 100,100);
	}

}
class Octagon extends Polygon {
	/**
	 * Constructs a eightsided polygon.
	 *
	 * @param titleX    The x value for the origin of the title string.
	 * @param titleY    The y value for the origin of the title string.
	 * @param messageX  The x value for the origin of the message string.
	 * @param messageY  The y value for the origin of the message string.
	 */
	public Octagon(int titleX, int titleY, int messageX, int messageY){
		super(8, titleX, titleY, messageX, messageY);
	}
}
class Polygon extends AbstractShape {
	/**
	 * Constructs a n-sided shape. Takes coordinates to place description and shapename strings.
	 *
	 * @param titleX    The x value for the origin of the title string.
	 * @param titleY    The y value for the origin of the title string.
	 * @param messageX  The x value for the origin of the message string.
	 * @param messageY  The y value for the origin of the message string.
	 */
	public Polygon(int sides, int titleX, int titleY, int messageX, int messageY){
		super(titleX, titleY, messageX, messageY);
		this.numSides = sides;
	}

	/**
	 * Uses trigonometry to draw a n-sided
	 * @param g
	 */
	public void draw(Graphics g){
		java.awt.Polygon tempPolygon = new java.awt.Polygon();
		double theta =  2 * Math.PI / numSides;
		double x,y;
		double xOffset = 150, yOffset = 430;
		for (int i = 0; i < numSides; ++i) {
			x = Math.cos(theta * i + Math.toRadians(22.5));
			y = Math.sin(theta * i + Math.toRadians(22.5));
			tempPolygon.addPoint((int) (x*70 + xOffset), (int) (y*70 + yOffset));
		}
		g.fillPolygon(tempPolygon);

	}


}