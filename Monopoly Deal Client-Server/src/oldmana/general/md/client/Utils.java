package oldmana.general.md.client;

import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Utils
{
	private static JButton button = new JButton();
	
	private static Font font = button.getFont();
	
	/**Sets the location of the component at a percent relative to the parent container. The location is centered.
	 * 
	 * @param c - Component to set location of
	 * @param xFrac - Fraction of x position
	 * @param yFrac - Fraction of y position
	 */
	public static void setLocationOfCentered(JComponent c, double xFrac, double yFrac)
	{
		c.setLocation((int) (c.getParent().getWidth() * xFrac) - c.getWidth() / 2, 
				(int) (c.getParent().getHeight() * yFrac) - c.getHeight() / 2);
	}
	
	/**Sets the location of the component at a percent relative to the parent container.
	 * 
	 * @param c - Component to set location of
	 * @param xFrac - Fraction of container's x
	 * @param yFrac - Fraction of container's y
	 */
	public static void setLocationOf(JComponent c, double xFrac, double yFrac)
	{
		c.setLocation((int) (c.getParent().getWidth() * xFrac), (int) (c.getParent().getHeight() * yFrac));
	}
	
	/**Sets the size of the component at a percent relative to the parent container.
	 * 
	 * @param c - Component to set size of
	 * @param xFrac - Fraction of container's x
	 * @param yFrac - Fraction of container's y
	 */
	public static void setSizeOf(JComponent c, double xFrac, double yFrac)
	{
		c.setSize((int) Math.round(c.getParent().getWidth() * xFrac), (int) Math.round(c.getParent().getHeight() * yFrac));
	}
	
	public static Font getFont(int type, int size)
	{
		return new Font(font.getFontName(), type, size);
	}
	
	public static FontMetrics getFontMetrics(Font font)
	{
		return button.getFontMetrics(font);
	}
}
