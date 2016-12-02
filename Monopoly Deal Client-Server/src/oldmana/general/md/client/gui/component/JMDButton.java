package oldmana.general.md.client.gui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import oldmana.general.md.client.Utils;
import oldmana.general.md.client.gui.utils.TextPainter;
import oldmana.general.md.client.gui.utils.TextPainter.Alignment;

public class JMDButton extends JButton
{
	public JMDButton()
	{
		super();
		
		
	}
	
	@Override
	public void paintComponent(Graphics cg)
	{
		BufferedImage img = Utils.createCompatibleImage(getWidth(), getHeight());
		Graphics g = img.getGraphics();
		g.setColor(new Color(200, 200, 200));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.DARK_GRAY);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		g.setColor(Color.BLACK);
		TextPainter tp = new TextPainter(getText(), Utils.getFont(Font.PLAIN, getHeight() / 2), new Rectangle(0, 0, getWidth(), getHeight()), false, false);
		tp.setHorizontalAlignment(Alignment.CENTER);
		tp.setVerticalAlignment(Alignment.CENTER);
		
		tp.paint((Graphics2D) g);
		if (!isEnabled())
		{
			g.setColor(new Color(0, 0, 0, 50));
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		cg.drawImage(img, 0, 0, this);
	}
}
