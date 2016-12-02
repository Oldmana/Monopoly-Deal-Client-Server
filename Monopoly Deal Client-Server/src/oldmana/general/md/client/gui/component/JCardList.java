package oldmana.general.md.client.gui.component;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import oldmana.general.md.client.Utils;
import oldmana.general.md.universal.card.Card;

public class JCardList extends JScrollPane
{
	private JComponent container = new JComponent() {};
	
	private List<JCard> cards = new ArrayList<JCard>();
	
	
	public JCardList()
	{
		super();
		getViewport().add(container);
	}
	
	public void addCard(JCard card)
	{
		cards.add(card);
		container.add(card);
		Utils.setSizeOf(card, 0.06, 0.2);
		updateCardView();
	}
	
	public List<JCard> getCards()
	{
		return cards;
	}
	
	public void updateCardView()
	{
		container.setPreferredSize(new Dimension((int) (cards.get(0).getWidth() * 1.2 * cards.size()), 500));
		
		int i = 0;
		for (JCard card : cards)
		{
			card.setLocation((int) (card.getWidth() * 1.2 * i), /**getHeight() / 2 - card.getHeight() / 2**/ 0);
			i++;
			System.out.println(card);
		}
	}
}
