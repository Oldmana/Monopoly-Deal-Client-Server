package oldmana.general.md.client;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Utils
{
	private static Font font = new JButton().getFont();
	
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
}
