package oldmana.general.md.client.gui.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLayeredPane;

import oldmana.general.md.client.Utils;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.CardSet;

public class JSet extends JExtendedComponent
{
	private CardSet set;
	
	public JSet(CardSet set)
	{
		this.set = set;
	}
	
	@Override
	public void paintUnmodified(Graphics g)
	{
		int i = 0;
		for (Card card : set.getCards())
		{
			Graphics sec = g.create(0, (int) (i * (1.0 / 3) * (getRealBounds().height / 2)), getRealBounds().width, getRealBounds().height / 2);
			Utils.drawCardOn(card, sec, new Dimension(getRealBounds().width, getRealBounds().height / 2), getRotation());
			i++;
		}
	}
}
