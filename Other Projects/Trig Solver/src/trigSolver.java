import java.awt.*;
import java.applet.*;

public class trigSolver extends Applet {
	int frame = 0;
    public void paint(Graphics g)
    {
        int unitCircleOriginX = 200;
        int unitCircleOriginY = 100;
        int unitCircleSize = 500+this.frame;

        int unitCircleCenterY = (unitCircleSize/2) + unitCircleOriginY;
        int unitCircleCenterX = (unitCircleSize/2) + unitCircleOriginX;

        g.drawOval(unitCircleOriginX, unitCircleOriginY, unitCircleSize, unitCircleSize);
        //Graphics apps are one of of those place uints would be nice
        int radius = unitCircleSize/2; //hypotenuse




        Triangle triangle = new Triangle(radius);
		triangle.draw(g, unitCircleCenterX, unitCircleCenterY);
        //side lengths




    }
	public boolean mouseDown(Event e, int x, int y)
	{
		repaint();
		this.frame++;
		return true;

	}
}

class Triangle
{

	private int adjacent;
	private int opposite;
	private double angle;
	// topleft X coordinate of the Cube's position // topleft y coordinate of the Cube's position
	public Triangle(int hypotenuse)
	{
		this.angle = Math.PI/4; //radians
		this.opposite = (int)Math.round( Math.sin(angle) *hypotenuse ) *-1;
		this.adjacent = (int) Math.round( Math.cos(angle) * hypotenuse );
	}
	public void draw(Graphics g, int anchorX, int anchorY)
	{

		g.setColor(Color.black);
		int[] x = {anchorX, anchorX+adjacent, anchorX+adjacent, anchorX};
		int[] y = {anchorY, anchorY, anchorY+opposite, anchorY};
		g.drawPolygon(x, y, x.length);
	}
}