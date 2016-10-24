package oldmana.general.md.server;

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
	
	public static ServerGame getGameInstance()
	{
		return game;
	}
}
