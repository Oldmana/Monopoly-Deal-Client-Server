package oldmana.general.md.universal.card;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile
{
	private List<Card> pile = new ArrayList<Card>();
	
	public DiscardPile()
	{
		
	}
	
	public void addCard(Card card)
	{
		pile.add(card);
	}
	
	public void clear()
	{
		pile.clear();
	}
	
	public List<Card> getPile()
	{
		return pile;
	}
}
