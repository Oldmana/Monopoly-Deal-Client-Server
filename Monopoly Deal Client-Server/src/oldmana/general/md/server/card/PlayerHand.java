package oldmana.general.md.server.card;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand
{
	private List<Card> cards = new ArrayList<Card>();
	
	public PlayerHand()
	{
		
	}
	
	/**Inserts a card to the end of the hand.
	 * 
	 * @param card - Card to be added
	 */
	public void addCard(Card card)
	{
		cards.add(card);
	}
	
	public Card cardAt(int index)
	{
		return cards.get(index);
	}
	
	public void removeCardAt(int index)
	{
		cards.remove(index);
	}
	
	public void moveCard(int from, int to)
	{
		Card card = cards.get(from);
		cards.remove(from);
		cards.add(to, card);
	}
	
	public List<Card> getHand()
	{
		return cards;
	}
	
	public int getCardCount()
	{
		return cards.size();
	}
}
