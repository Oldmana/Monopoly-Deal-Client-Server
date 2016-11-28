package oldmana.general.md.universal.player;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.universal.card.Card;

public class CashPile
{
	private List<Card> cash = new ArrayList<Card>();
	
	public CashPile()
	{
		
	}
	
	public void addCash(Card card)
	{
		cash.add(card);
	}
	
	public List<Card> getCash()
	{
		return cash;
	}
	
	public void removeCash(Card card)
	{
		cash.remove(card);
	}
}
