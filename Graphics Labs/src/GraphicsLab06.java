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
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Square());
		shapes.add(new Triangle());
		shapes.add(new Octagon());
		shapes.add(new Circle());

		drawGrid(g);

		for(Shape shape: shapes)
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
abstract class AbstractShape{
    int numSides;
    String shapeName = this.getClass().getName();
    int titleX, titleY;
    int messageX, messageY;
    public AbstractShape(){
        throw new InternalError("YO");
    }
    public AbstractShape(String titleX, String titleY, String messageX, String messageY){
        this.titleX = titleX;
        this.titleY = titleY;
        this.messageX = messageX;
        this.messageY = messageY;
    }
    public void displayName(Graphics g){
        g.drawString();
    }
    public void displayNumSides(Graphics g){
        g.drawString("A " + shapeName + " has " + numSides + " sides.", messageX, messageY);
    }
}
class Square extends AbstractShape implements Drawable {

    public void drawShape(Graphics g){

    }


}
class Triangle extends AbstractShape implements Drawable {

}
class Circle extends AbstractShape implements Drawable {

}
class Octagon extends AbstractShape implements Drawable {

}