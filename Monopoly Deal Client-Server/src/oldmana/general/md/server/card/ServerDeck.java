package oldmana.general.md.server.card;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.universal.card.Card;

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
	
	public void setDeck(List<Card> newDeck)
	{
		deck = newDeck;
	}
	
	public List<Card> getDeck()
	{
		return deck;
	}
}
