package oldmana.general.md.server.card;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand
{
private List<Card> cards;
	
	public PlayerHand()
	{
		cards = new ArrayList<Card>();
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
	
	public List<Card> getHand()
	{
		return cards;
	}
	
	public int getCardCount()
	{
		return cards.size();
	}
}
