package oldmana.general.md.client.gui.component;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLayeredPane;

import oldmana.general.md.universal.card.CardSet;

public class JSet extends JLayeredPane
{
	private CardSet set;
	
	private Point centeredLoc;
	private int rotation = 0;
	
	public JSet(CardSet set)
	{
		this.set = set;
	}
	
	public void setCenterLocation(Point p)
	{
		centeredLoc = p;
		
		
	}
	
	@Override
	public void setBounds(int x1, int y1, int width, int height)
	{
		
	}
	
	public void setRotation(int rotation)
	{
		this.rotation = rotation;
	}
	
	public int getRotation()
	{
		return rotation;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
	}
}
