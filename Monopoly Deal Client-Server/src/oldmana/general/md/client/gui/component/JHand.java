package oldmana.general.md.client.gui.component;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class JHand extends JCardPile
{
	
	
	@Override
	public void putCard(JCard card)
	{
		super.putCard(card);
		
		card.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent event)
			{
				// TODO: Handle click on card in hand
			}
			
			@Override
			public void mouseEntered(MouseEvent event)
			{
				
			}
			
			@Override
			public void mouseExited(MouseEvent event)
			{
				
			}
		});
		
		card.addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent event)
			{
				
			}
		});
	}
	
	@Override
	public void refresh()
	{
		super.refresh();
		
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}
}
