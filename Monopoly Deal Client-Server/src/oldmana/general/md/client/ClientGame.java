package oldmana.general.md.client;

import oldmana.general.md.client.card.ClientDeck;
import oldmana.general.md.universal.player.Player;

public class ClientGame
{
	private int self;
	private Player[] players; // Maximum 3 players
	private ClientDeck deck;
	
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
}
