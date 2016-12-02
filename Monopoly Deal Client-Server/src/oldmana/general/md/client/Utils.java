package oldmana.general.md.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComponent;

import oldmana.general.md.client.gui.component.JExtendedComponent;
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
	
	public static void setRealLocationOfCentered(JExtendedComponent c, double xFrac, double yFrac)
	{
		c.setRealLocationCentered((int) (c.getParent().getWidth() * xFrac) - c.getWidth() / 2, 
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
	
	public static void setRealLocationOf(JExtendedComponent c, double xFrac, double yFrac)
	{
		c.setRealLocation((int) (c.getParent().getWidth() * xFrac), (int) (c.getParent().getHeight() * yFrac));
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
	
	public static void setRealSizeOf(JExtendedComponent c, double xFrac, double yFrac)
	{
		c.setRealSize((int) Math.round(c.getParent().getWidth() * xFrac), (int) Math.round(c.getParent().getHeight() * yFrac));
	}
	
	public static Font getFont(int type, int size)
	{
		return new Font(font.getFontName(), type, size);
	}
	
	public static FontMetrics getFontMetrics(Font font)
	{
		return button.getFontMetrics(font);
	}
	
	public static BufferedImage createCompatibleImage(int width, int height)
	{
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration()
		.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
	}
	
	public static void drawRotatedImage(Graphics2D g, BufferedImage image, double degrees, int width, int height)
	{
		double rotationRequired = Math.toRadians(degrees);
		double centerX = width / 2;
		double centerY = height / 2;
		AffineTransform prev = g.getTransform();
		g.rotate(rotationRequired, centerX, centerY);
		int startX = (int) (centerX - image.getWidth() / 2);
		int startY = (int) (centerY - image.getHeight() / 2);
		g.drawImage(image, startX, startY, null);
		g.setTransform(prev);
	}
	
	public static void drawCardOn(Card card, Graphics g, Dimension size, double rotation)
	{
		Color[] valueColors = new Color[] {Color.YELLOW, Color.PINK, Color.GREEN, Color.CYAN, Color.MAGENTA, null, 
				null, null, null, Color.ORANGE};
		
		int width = size.width;
		int height = size.height;
		
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
	
	public static Point rotate(Point center, Point point, double angle)
	{
		angle = Math.toRadians(-angle);
		double s = Math.sin(angle);
		double c = Math.cos(angle);
		
		point.x -= center.x;
		point.y -= center.y;
		
		double rX = point.x * c - point.y * s;
		double rY = point.x * s + point.y * c;
		
		return new Point((int) rX + center.x, (int) rY + center.y/**(int) Math.round(rX), (int) Math.round(rY)**/);
	}
	
	public static int[] getWidthHeightWithRotation(Rectangle r, double rotation)
	{
		int[] wh = new int[2];
		Point center = new Point((int) r.getCenterX(), (int) r.getCenterY());
		Polygon p = new Polygon();
		Point p1 = rotate(center, new Point((int) r.getMinX(), (int) r.getMinY()), rotation);
		Point p2 = rotate(center, new Point((int) r.getMaxX(), (int) r.getMinY()), rotation);
		Point p3 = rotate(center, new Point((int) r.getMaxX(), (int) r.getMaxY()), rotation);
		Point p4 = rotate(center, new Point((int) r.getMinX(), (int) r.getMaxY()), rotation);
		p.addPoint((int) p1.getX(), (int) p1.getY());
		p.addPoint((int) p2.getX(), (int) p2.getY());
		p.addPoint((int) p3.getX(), (int) p3.getY());
		p.addPoint((int) p4.getX(), (int) p4.getY());
		Rectangle pB = p.getBounds();
		wh[0] = (int) pB.getWidth();
		wh[1] = (int) pB.getHeight();
		return wh;
	}
}
