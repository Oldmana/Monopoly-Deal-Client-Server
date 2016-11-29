package oldmana.general.md.client.gui.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLayeredPane;

import oldmana.general.md.client.Utils;
import oldmana.general.md.universal.card.CardSet;

public class JSet extends JLayeredPane
{
	private CardSet set;
	
	private Point centeredLoc;
	private double rotation = 0;
	private Dimension realSize;
	
	public JSet(CardSet set)
	{
		this.set = set;
	}
	
	public void setCenterLocation(Point p)
	{
		centeredLoc = p;
		
		
	}
	
	public void setRotation(int rotation)
	{
		this.rotation = rotation;
		
		
	}
	
	public double getRotation()
	{
		return rotation;
	}
	
	public void setRealSize(Dimension d)
	{
		this.realSize = d;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
	}
}
