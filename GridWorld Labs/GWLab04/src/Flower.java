package info.gridworld.actor;

import java.awt.Color;

/**
 * A <code>Flower</code> is an actor that darkens over time. Some actors drop
 * flowers as they move. <br />
 * The API of this class is testable on the AP CS A and AB exams.
 */

public class Flower extends Actor
{
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final double CHANGE_FACTOR = 25;
    private Color targetColor;

    // lose 5% of color value in each step

    /**
     * Constructs a pink flower.
     */
    public Flower()
    {
        setColor(DEFAULT_COLOR);
    }

    /**
     * Constructs a flower of a given color.
     * @param initialColor the initial color of this flower
     */
    public Flower(Color targetColor)
    {
        this.targetColor = targetColor;
        setColor(DEFAULT_COLOR);
    }

    /**
     * Causes the color of this flower to darken.
     */
    public void act()
    {
        Color c = getColor();
        int red, green, blue;

        if (c.getRed() >= targetColor.getRed()){
               red = targetColor.getRed();
        }
        else {
           red = (int) (c.getRed() + (CHANGE_FACTOR));
           if(red>255) red = targetColor.getRed();
        }


        if (c.getBlue() >= targetColor.getBlue()){
            blue = targetColor.getBlue();
        }
        else {
            blue = (int) (c.getBlue() + (CHANGE_FACTOR));
            if(blue>255) blue = targetColor.getBlue();
        }

        if (c.getGreen() >= targetColor.getGreen()){
            green = targetColor.getGreen();
        }
        else {
            green = (int) (c.getGreen() + (CHANGE_FACTOR));
            if(green>255) green = targetColor.getGreen();
        }

        System.out.println("r"+red+ "g"+green+"b"+blue);
        setColor(new Color(red, green, blue));
    }
}
