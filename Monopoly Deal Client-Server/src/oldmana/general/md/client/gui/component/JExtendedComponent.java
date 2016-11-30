package oldmana.general.md.client.gui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import oldmana.general.md.client.Utils;

public abstract class JExtendedComponent extends JComponent
{
	private Rectangle realBounds;
	
	private double rotation = 0.0;
	
	public JExtendedComponent()
	{
		
	}
	
	/**
	@Override
	public void setBounds(int x, int y, int width, int height)
	{
		realBounds = new Rectangle(x, y, width, height);
	}
	**/
	
	public void setRealBounds(int x, int y, int width, int height)
	{
		realBounds = new Rectangle(x, y, width, height);
		adjustToRotation();
	}
	
	public Rectangle getRealBounds()
	{
		return realBounds;
	}
	
	public void setRotation(int rotation)
	{
		this.rotation = rotation;
		
		adjustToRotation();
	}
	
	public double getRotation()
	{
		return rotation;
	}
	
	public void adjustToRotation()
	{
		int[] wh = Utils.getWidthHeightWithRotation(realBounds, rotation);
		
		setBounds(realBounds.x - ((wh[0] - realBounds.width) / 2), realBounds.y - ((wh[1] - realBounds.height) / 2), 
				wh[0], wh[1]);
		
	}
	
	public abstract void paintUnmodified(Graphics g);
	
	/**Override paintUnmodified(Graphics) instead.
	 * 
	 */
	@Override
	public void paintComponent(Graphics cg)
	{
		BufferedImage unrotated = Utils.createCompatibleImage(realBounds.width, realBounds.height);
		BufferedImage rotated = Utils.createCompatibleImage(cg.getClipBounds().width, cg.getClipBounds().height);
		Graphics g = unrotated.getGraphics();
		Graphics rg = rotated.getGraphics();
		paintUnmodified(g);
		Utils.drawRotatedImage((Graphics2D) rg, unrotated, rotation, rotated.getWidth(), rotated.getHeight());
		cg.drawImage(rotated, 0, 0, null);
	}
}
