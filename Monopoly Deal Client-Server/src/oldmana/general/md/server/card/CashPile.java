package oldmana.general.md.server.card;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.universal.card.Card;

public class CashPile
{
	private List<Card> pile = new ArrayList<Card>();
	
	public CashPile()
	{
		
	}
	
	public void addCash(Card card)
	{
		pile.add(card);
	}
	
	public void removeCash(Card card)
	{
		pile.remove(card);
	}
	
	public List<Card> getCash()
	{
		return pile;
	}
	
	public int getTotalCashValue()
	{
		int value = 0;
		for (Card card : pile)
		{
			value += card.getValue();
		}
		return value;
	}
}
