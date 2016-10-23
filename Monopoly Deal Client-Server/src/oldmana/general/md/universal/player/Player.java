package oldmana.general.md.universal.player;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.universal.card.CardSet;

public class Player
{
	private int ID;
	
	private List<CardSet> properties = new ArrayList<CardSet>();
	private CashPile cash = new CashPile();
	
	private int cardsInHand;
	
	public Player(int ID)
	{
		this.ID = ID;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void addCardSet(CardSet set)
	{
		properties.add(set);
	}
}
