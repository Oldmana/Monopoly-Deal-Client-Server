package oldmana.general.md.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;

import oldmana.general.md.client.gui.utils.TextPainter;
import oldmana.general.md.client.gui.utils.TextPainter.Alignment;
import oldmana.general.md.universal.card.Card;

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
	
	public static void drawCardOn(Card card, Graphics g, double rotation)
	{
		Color[] valueColors = new Color[] {Color.YELLOW, Color.PINK, Color.GREEN, Color.CYAN, Color.MAGENTA, null, 
				null, null, null, Color.ORANGE};
		
		int width = g.getClipBounds().width;
		int height = g.getClipBounds().height;
		
		g.setColor(valueColors[card.getValue() - 1]);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		g.setColor(Color.BLACK);
		TextPainter valueTL = new TextPainter("$" + card.getValue() + "M", Utils.getFont(Font.PLAIN, 12), new Rectangle(0, 0, width, height), false, false);
		valueTL.setHorizontalAlignment(Alignment.LEFT);
		valueTL.setVerticalAlignment(Alignment.TOP);
		TextPainter valueRB = new TextPainter("$" + card.getValue() + "M", Utils.getFont(Font.PLAIN, 12), new Rectangle(0, 0, width, height), false, false);
		valueRB.setHorizontalAlignment(Alignment.RIGHT);
		valueRB.setVerticalAlignment(Alignment.BOTTOM);
		valueTL.paint((Graphics2D) g);
		valueRB.paint((Graphics2D) g);
		TextPainter name = new TextPainter(card.getName(), Utils.getFont(Font.PLAIN, (int) (height * 0.1)), new Rectangle(0, 0, width, height), false, false);
		name.setHorizontalAlignment(Alignment.CENTER);
		name.setVerticalAlignment(Alignment.CENTER);
		name.paint((Graphics2D) g);
	}
}
