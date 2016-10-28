package oldmana.general.md.server;

import java.util.List;

import oldmana.general.md.server.card.ServerDeck;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.DiscardPile;
import oldmana.general.md.universal.player.Player;

public class ServerGame
{
	private static ServerGame game;
	
	private Player[] players;
	
	private ServerDeck deck;
	private DiscardPile discardPile;
	
	private List<Card> cardRegistry;
	
	public ServerGame()
	{
		game = this;
	}
	
	/**Processes a player playing a card on the server side.
	 * 
	 * @param card - Card being played
	 * @param owner - Owner of the card
	 */
	public void playCard(Card card, Player owner)
	{
		
	}
	
	public ServerDeck getDeck()
	{
		return deck;
	}
	
	public DiscardPile getDiscardPile()
	{
		return discardPile;
	}
	
	public Card drawCard()
	{
		if (!deck.hasNext())
		{
			reshuffle();
		}
		return deck.getNext(true);
	}
	
	public void reshuffle()
	{
		if (!deck.hasNext()) // Makin' sure..
		{
			deck.reshuffle(discardPile);
		}
	}
	
	public Card getCardbyID(int ID)
	{
		for (Card card : cardRegistry)
		{
			if (card.getID() == ID)
			{
				return card;
			}
		}
		return null;
	}
	
	public static ServerGame getGameInstance()
	{
		return game;
	}
}
