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
			shape.drawShape(g);
			shape.displayName(g);
			shape.displayNumSides(g);
		}
	}

	public void drawGrid(Graphics g)
	{
		g.drawLine(0,300,800,300);
		g.drawLine(400,0,400,600);
	}
}
interface Drawable {
	public void drawShape(Graphics g);
	public void displayName(Graphics g);
	public void displayNumSides(Graphics g);
}
abstract class AbstractShape implements Drawable{
	int numSides;
	String shapeName = this.getClass().getName();
	int titleX, titleY;
	int messageX, messageY;

	public AbstractShape(int titleX, int titleY, int messageX, int messageY){
		this.titleX = titleX;
		this.titleY = titleY;
		this.messageX = messageX;
		this.messageY = messageY;
	}
	public void displayName(Graphics g){
		g.drawString(this.shapeName, titleX, titleY);
	}
	public void displayNumSides(Graphics g){
		g.drawString("A " + shapeName + " has " + numSides + " sides.", messageX, messageY);
	}
}
class Square extends AbstractShape {

	public Square(int titleX, int titleY, int messageX, int messageY){
		super(titleX, titleY, messageX, messageY);
	}
	public void drawShape(Graphics g){
		g.drawRect(100,100,100,100);
	}


}
class Triangle extends AbstractShape {
	public Triangle(int titleX, int titleY, int messageX, int messageY){
		super(titleX, titleY, messageX, messageY);
	}
	public void drawShape(Graphics g){
		g.fillPolygon(new int[] {500,600,550},new int[] {200,200,120},3);
	}

}
class Circle extends AbstractShape {
	public Circle(int titleX, int titleY, int messageX, int messageY){
		super(titleX, titleY, messageX, messageY);
	}
	public void drawShape(Graphics g){
		g.fillOval(500, 400, 100,100);
	}

}
class Octagon extends AbstractShape {
	public Octagon(int titleX, int titleY, int messageX, int messageY){
		super(titleX, titleY, messageX, messageY);
	}
	public void drawShape(Graphics g){


	}


}