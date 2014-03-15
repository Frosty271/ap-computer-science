import java.applet.Applet;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
public class GraphicsLab04 extends Applet
{
	//Rectangles and squares are shapes that are drawable. Both can have gradients or solidsColors, which are fills
	public void paint(Graphics g){
		Gradient blackToWhite = new Gradient(Color.BLACK, Color.WHITE);
		Gradient blackToGreen = new Gradient(Color.BLACK, Color.GREEN);
		Stroke heavyGreen = new Stroke(Color.GREEN, 10);
		Stroke thinGray= new Stroke(Color.GRAY, 2);
		ArrayList<Drawable> shapes = new ArrayList<Drawable>();
		shapes.add(new Rectangle(blackToWhite, thinGray, 100,100,200,100));
		shapes.add(new Square(blackToGreen, heavyGreen,400,100,300));
		for(Drawable shape: shapes){
			shape.draw(g);
		}
	}
}
interface Drawable{
	abstract void draw(Graphics g);
}
abstract class Fill{
	abstract public void draw(Graphics g, int xOri, int yOri, int h, int w);
}
class Gradient extends Fill{
	Color startColor, endColor;

	public Gradient(Color startColor, Color endColor){
		this.startColor = startColor;
		this.endColor = endColor;
	}
	public void draw(Graphics g, int xOri, int yOri, int w, int h){
		Color tempColor;

		float tempDivisor = h;
		final float redStep = ( startColor.getRed() + endColor.getRed() )/tempDivisor;
		final float greenStep = ( startColor.getGreen() + endColor.getGreen() )/tempDivisor;
		final float blueStep = ( startColor.getBlue() + endColor.getBlue() )/tempDivisor;

		final int startRed = startColor.getRed();
		final int startGreen = startColor.getGreen();
		final int startBlue = startColor.getBlue();

		int tempRed, tempGreen, tempBlue;

		int y = yOri;
		for(int i = 0; i < h; i++){
			System.out.println(redStep);
			tempRed= (int)(redStep*i)+startRed;
			tempGreen= (int)(greenStep*i)+startGreen;
			tempBlue= (int)(blueStep*i)+startBlue;
			tempColor = new Color(tempRed, tempGreen, tempBlue);
			g.setColor(tempColor);
			System.out.println(tempColor);
			g.drawLine(xOri, y, xOri+w, y);
			y++;
		}
		g.setColor(Color.BLACK);
	}

}
class SolidColor extends Fill{
	Color color;

	public SolidColor(Color color){
		this.color = color;
	}
	public void draw(Graphics g, int xOri, int yOri, int w, int h){
		g.setColor(this.color);
		g.fillRect(xOri, yOri, w, h);
		g.setColor(Color.BLACK);
	}

}
class Stroke {
	Color color;
	int weight;

	public Stroke(Color color, int weight){
		this.color = color;
		this.weight = weight;
	}
	public void draw(Graphics g, int xOri, int yOri, int w, int h){
		g.setColor(this.color);
		for (int i = 0; i < this.weight; i++){
			g.drawRect(xOri - i, yOri - i, w + i*2, h + i*2);
		}
		g.setColor(Color.BLACK);
	}

}

class Rectangle implements Drawable{
	int h, w;
	int xOri, yOri;
	Fill fill;
	Stroke stroke;

	Rectangle(Fill fill, Stroke stroke, int xOri, int yOri, int h, int w){
		this.h=h;
		this.w=w;
		this.xOri=xOri;
		this.yOri=yOri;
		this.fill = fill;
		this.stroke = stroke;
	}
	public void draw(Graphics g){
		g.drawRect(xOri,yOri,w,h);
		fill.draw(g,xOri+1,yOri+1,w-1,h-1);
		stroke.draw(g,xOri,yOri,w,h);
	}
}
class Square extends Rectangle implements Drawable{
	int l;

	Square(Fill fill, Stroke stroke, int xOri, int yOri, int l){
		super(fill,stroke, xOri,yOri, l, l);
		this.l = l;
	}


}