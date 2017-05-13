package oldmana.general.md.client.gui.component.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;

import javax.swing.JComponent;

import oldmana.general.md.client.gui.component.JHand;
import oldmana.general.md.client.gui.component.JPlayerTable;

public class TableLayout implements LayoutManager2
{
	public static final String PLAYER_1 = "PLAYER_1";
	public static final String PLAYER_2 = "Player_2";
	public static final String PLAYER_3 = "Player_3";
	public static final String PLAYER_4 = "Player_4";
	public static final String DECK = "DECK";
	public static final String DISCARD = "DISCARD";
	public static final String HAND = "HAND";
	
	private JPlayerTable[] players = new JPlayerTable[4];
	private JComponent deck;
	private JComponent discard;
	private JHand hand;
	
	
	@Override
	public void addLayoutComponent(Component c, Object type)
	{
		if (type != null && type instanceof String)
		{
			addLayoutComponent((String) type, c);
		}
		else
		{
			throw new IllegalArgumentException("Must have valid constraint.");
		}
	}
	
	@Override
	public void addLayoutComponent(String type, Component c)
	{
		if (type.equals(PLAYER_1))
		{
			players[0] = (JPlayerTable) c;
		}
		else if (type.equals(PLAYER_2))
		{
			players[1] = (JPlayerTable) c;
		}
		else if (type.equals(PLAYER_3))
		{
			players[2] = (JPlayerTable) c;
		}
		else if (type.equals(PLAYER_4))
		{
			players[3] = (JPlayerTable) c;
		}
		else if (type.equals(DECK))
		{
			deck = (JComponent) c;
		}
		else if (type.equals(DISCARD))
		{
			discard = (JComponent) c;
		}
		else if (type.equals(HAND))
		{
			hand = (JHand) c;
		}
	}
	
	@Override
	public void layoutContainer(Container c)
	{
		Dimension size = c.getSize();
		
		
	}
	
	@Override
	public Dimension minimumLayoutSize(Container arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Dimension preferredLayoutSize(Container arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void removeLayoutComponent(Component c)
	{
		// Not gonna happen
	}
	
	@Override
	public float getLayoutAlignmentX(Container arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public float getLayoutAlignmentY(Container arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void invalidateLayout(Container arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Dimension maximumLayoutSize(Container arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
