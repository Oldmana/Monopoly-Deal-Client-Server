package oldmana.general.md.server.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.DiscardPile;

/**A server representation of a deck. The server actually knows what's in the deck, unlike the client.
 *
 */
public class ServerDeck
{
	private List<Card> deck;
	
	public ServerDeck()
	{
		deck = new ArrayList<Card>();
	}
	
	public ServerDeck(List<Card> deck)
	{
		this.deck = deck;
	}
	
	public void appendBottom(Card card)
	{
		deck.add(card);
	}
	
	public void appendTop(Card card)
	{
		deck.add(0, card);
	}
	
	public Card getNext(boolean remove)
	{
		Card card = deck.get(0);
		if (remove)
		{
			deck.remove(0);
		}
		return card;
	}
	
	public boolean hasNext()
	{
		return !deck.isEmpty();
	}
	
	public void setDeck(List<Card> newDeck)
	{
		deck = newDeck;
	}
	
	public List<Card> getDeck()
	{
		return deck;
	}
	
	/**Shuffles the cards then sets the deck to the shuffled cards.
	 * 
	 * @param cards - The cards to shuffle
	 */
	public void shuffle(List<Card> cards)
	{
		Collections.shuffle(cards);
		setDeck(cards);
	}
	
	/**Shuffles the discard pile, sets the deck to the shuffled cards, then clears the discard pile.
	 * 
	 * @param discardPile - The discard pile to reshuffle
	 */
	public void reshuffle(DiscardPile discardPile)
	{
		Collections.shuffle(discardPile.getPile());
		setDeck(discardPile.getPile());
		discardPile.clear();
	}
}
