package oldmana.general.md.client.gui.component;

import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;

import oldmana.general.md.client.GraphicsUtils;

public class JCardPile extends JLayeredPane implements PixelRatio
{
	private List<JCard> cards = new ArrayList<JCard>();
	
	/** 0 indicates infinite
	 */
	private int visibleCards = 4;
	
	private CardPileAlignment alignment = CardPileAlignment.CENTER;
	private Orientation orientation = Orientation.HORIZONTAL;
	private boolean spread = true;
	private boolean firstToLastVisibility = true;
	
	
	public JCardPile()
	{
		initialize();
	}
	
	public JCardPile(int visibleCards, int width)
	{
		this.visibleCards = visibleCards;
		initialize();
	}
	
	public void initialize()
	{
		setLayout(null);
		
		addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent event)
			{
				refresh();
			}
		});
	}
	
	/**Puts a card in the front of the stack
	 * 
	 * @param card
	 */
	public void putCard(JCard card)
	{
		cards.add(0, card);
		refresh();
	}
	
	/**Appends a card at the end of the stack
	 * 
	 * @param card
	 */
	public void appendCard(JCard card)
	{
		cards.add(card);
		refresh();
	}
	
	public void removeCard(JCard card)
	{
		cards.remove(card);
	}
	
	public int getCardCount()
	{
		return cards.size();
	}
	
	public void setAlignment(CardPileAlignment alignment)
	{
		this.alignment = alignment;
	}
	
	public void setOrientation(Orientation orientation)
	{
		this.orientation = orientation;
	}
	
	public void setSpread(boolean spread)
	{
		this.spread = spread;
	}
	
	public boolean getFirstToLastVisibility()
	{
		return firstToLastVisibility;
	}
	
	public void setFirstToLastVisibility(boolean vis)
	{
		firstToLastVisibility = vis;
	}
	
	
	public void refresh()
	{
		int cardCount = spread ? Math.min(cards.size(), visibleCards <= 0 ? cards.size() : visibleCards) : visibleCards;
		int length = orientation == Orientation.HORIZONTAL ? getWidth() : getHeight();
		removeAll();
		for (int i = 0 ; i < cardCount ; i++)
		{
			if (cards.size() > i)
			{
				add(cards.get(firstToLastVisibility ? i : cards.size() - i - 1), i);
			}
		}
		for (int i = 0 ; i < cardCount ; i++)
		{
			if (cards.size() > i)
			{
				JCard card = cards.get(i);
				//add(card, leastToGreatestVisibility ? i : cardCount - i - 1);
				
				card.setSize(GraphicsUtils.adjustToDimension(getSize(), card.getXToYRatio()));
				int cardLength = orientation == Orientation.HORIZONTAL ? card.getWidth() : card.getHeight();
				
				//int interval = (length) / (cardCount - 1);
				int maxInterval = (length / cardCount);
				//maxInterval += (card.getWidth() > maxInterval ? -(card.getWidth() / cardCount * (cardCount - 1)) : 0);
				
				int offset = Math.max(0, alignment == CardPileAlignment.LEFT || alignment == CardPileAlignment.TOP ? 0 : 
					(maxInterval - cardLength) / (alignment == CardPileAlignment.RIGHT || alignment == CardPileAlignment.BOTTOM ? 1 : 
						2));
				
				if (cardLength <= maxInterval)
				{
					card.setLocation(orientation == Orientation.HORIZONTAL ? offset + (maxInterval * i) : 0, 
							orientation == Orientation.VERTICAL ? offset + (maxInterval * i) : 0);
				}
				else
				{
					card.setLocation(orientation == Orientation.HORIZONTAL ? (int) Math.floor(((length - cardLength) / 
							(cardCount - 1)) * i) : 0, orientation == Orientation.VERTICAL ? (int) Math.floor(((length - cardLength) 
									/ (cardCount - 1)) * i) : 0);
					System.out.println(card.getLocation());
				}
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}

	@Override
	public double getXToYRatio()
	{
		return getWidth() / getHeight();
	}
	
	public static enum CardPileAlignment
	{
		LEFT, CENTER, RIGHT, TOP, BOTTOM
	}
	
	public static enum Orientation
	{
		HORIZONTAL, VERTICAL
	}
}
