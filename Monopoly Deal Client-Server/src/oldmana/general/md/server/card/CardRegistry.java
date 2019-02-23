package oldmana.general.md.server.card;

import java.util.ArrayList;
import java.util.List;

public class CardRegistry
{
	private static List<Card> cards = new ArrayList<Card>();
	
	private static int nextID = 0;
	
	public static void registerCard(Card card)
	{
		cards.add(card);
	}
	
	public static Card getCardByID(int ID)
	{
		for (Card card : cards)
		{
			if (card.getID() == ID)
			{
				return card;
			}
		}
		return null;
	}
	
	public static int generateCardID()
	{
		return nextID++;
	}
}
