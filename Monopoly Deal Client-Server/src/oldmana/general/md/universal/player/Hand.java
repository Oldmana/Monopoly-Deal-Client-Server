package oldmana.general.md.universal.player;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.universal.card.Card;

/**Contains the cards in a player's hand, in order. The server knows all hands, while the client typically
 * only see its own hand.
 *
 */
public class Hand
{
	private List<Card> cards;
	
	public Hand()
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
	
	public int cardCount()
	{
		return cards.size();
	}
}
