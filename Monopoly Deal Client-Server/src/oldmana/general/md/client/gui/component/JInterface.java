package oldmana.general.md.client.gui.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JLayeredPane;

import oldmana.general.md.client.Utils;

public class JInterface extends JLayeredPane
{
	private InterfaceType type;
	
	public JInterface(InterfaceType type)
	{
		this.type = type;
	}
	
	@Override
	public void paintComponent(Graphics cg)
	{
		BufferedImage img = Utils.createCompatibleImage(getWidth(), getHeight());
		Graphics g = img.getGraphics();
		g.setColor(new Color(200, 200, 200, 50));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(240, 240, 240));
		g.fillRect(0, (int) (getHeight() * 0.3), getWidth(), (int) (getHeight() * 0.4));
		
		
		cg.drawImage(img, 0, 0, this);
	}
	
	public enum InterfaceType
	{
		CARD_SELECT
	}
}
