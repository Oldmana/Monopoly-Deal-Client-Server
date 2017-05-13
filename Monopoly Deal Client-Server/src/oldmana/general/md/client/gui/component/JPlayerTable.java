package oldmana.general.md.client.gui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComponent;

import oldmana.general.md.client.GraphicsUtils;
import oldmana.general.md.client.gui.component.JCardPile.CardPileAlignment;
import oldmana.general.md.client.gui.component.JCardPile.Orientation;
import oldmana.general.md.universal.card.PropertyCard;
import oldmana.general.md.universal.card.PropertyCard.PropertyType;

public class JPlayerTable extends JComponent
{
	private JCardPile hand;
	private JCardPile money;
	
	private JCardPileList properties = new JCardPileList();
	
	public JPlayerTable()
	{
		for (int i = 0 ; i < 8 ; i++)
		{
		JCardPile pile = new JCardPile(4, 0);
		pile.setAlignment(CardPileAlignment.TOP);
		pile.setOrientation(Orientation.VERTICAL);
		pile.setFirstToLastVisibility(false);
		pile.setSpread(false);
		pile.putCard(new JCard(new PropertyCard(20, PropertyType.RED)));
		pile.putCard(new JCard(new PropertyCard(21, PropertyType.RED)));
		properties.addPile(pile);
		}
		
		JCardPile pile2 = new JCardPile(4, 0);
		pile2.setAlignment(CardPileAlignment.TOP);
		pile2.setOrientation(Orientation.VERTICAL);
		pile2.setFirstToLastVisibility(false);
		pile2.setSpread(false);
		pile2.putCard(new JCard(new PropertyCard(22, PropertyType.GREEN)));
		pile2.putCard(new JCard(new PropertyCard(23, PropertyType.GREEN)));
		
		
		properties.addPile(pile2);
		
		hand = new JCardPile(11, 0);
		hand.putCard(new JCard(new PropertyCard(24, PropertyType.GREEN)));
		hand.putCard(new JCard(new PropertyCard(25, PropertyType.GREEN)));
		hand.putCard(new JCard(new PropertyCard(26, PropertyType.GREEN)));
		hand.putCard(new JCard(new PropertyCard(27, PropertyType.GREEN)));
		money = new JCardPile(11, 0);
		money.putCard(new JCard(new PropertyCard(28, PropertyType.PURPLE)));
		money.putCard(new JCard(new PropertyCard(29, PropertyType.PURPLE)));
		money.putCard(new JCard(new PropertyCard(30, PropertyType.PURPLE)));
		money.putCard(new JCard(new PropertyCard(31, PropertyType.PURPLE)));
		
		
		add(properties.getScrollPane());
		add(hand);
		add(money);
		
		addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent event)
			{
				if (getWidth() > getHeight())
				{
					hand.setSize(GraphicsUtils.adjustToDimension(new Dimension(getWidth() / 4 - (getWidth() / 32), getHeight()), 1.6));
					hand.setLocation(getWidth() / 64, getHeight() / 2 - hand.getHeight() / 2);
					money.setSize(GraphicsUtils.adjustToDimension(new Dimension(getWidth() / 4 - (getWidth() / 32), getHeight()), 1.6));
					money.setLocation((int) ((getWidth() * 0.75) + (getWidth() / 64)), getHeight() / 2 - money.getHeight() / 2);
					
					properties.getScrollPane().setLocation(getWidth() / 4, 0);
					properties.getScrollPane().setSize(getWidth() / 2, getHeight());
				}
				else
				{
					hand.setSize(GraphicsUtils.adjustToDimension(new Dimension(getWidth(), getHeight() / 4 - (getHeight() / 32)), 1.6));
					hand.setLocation(getWidth() / 2 - hand.getWidth() / 2, getHeight() / 64);
					money.setSize(GraphicsUtils.adjustToDimension(new Dimension(getWidth(), getHeight() / 4 - (getHeight() / 32)), 1.6));
					money.setLocation(getWidth() / 2 - money.getWidth() / 2, (int) ((getHeight() * 0.75) + (getHeight() / 64)));
					
					properties.getScrollPane().setLocation(0, getHeight() / 4);
					properties.getScrollPane().setSize(getWidth(), getHeight() / 2);
				}
			}
		});
	}
	
	public JCardPile getHand()
	{
		return hand;
	}
	
	public JCardPile getMoney()
	{
		return money;
	}
	
	public JCardPileList getProperties()
	{
		return properties;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}
}
