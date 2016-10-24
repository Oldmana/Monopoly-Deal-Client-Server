package oldmana.general.md.client;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.client.card.ClientDeck;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.player.Player;

public class ClientGame
{
	private int self;
	private Player[] players; // Maximum 3 players
	private ClientDeck deck;
	
	private List<Card> cardCache = new ArrayList<Card>();
	
	public ClientGame()
	{
		
	}
	
	public Player getSelf()
	{
		for (Player p : getPlayers())
		{
			if (p.getID() == self)
			{
				return p;
			}
		}
		return null;
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
	
	public Player getPlayerByID(int ID)
	{
		for (Player p : getPlayers())
		{
			if (p.getID() == ID)
			{
				return p;
			}
		}
		return null;
	}
	
	public ClientDeck getDeck()
	{
		return deck;
	}
	
	public Card getCardbyID(int ID)
	{
		for (Card card : cardCache)
		{
			if (card.getID() == ID)
			{
				return card;
			}
		}
		return null;
	}
}
