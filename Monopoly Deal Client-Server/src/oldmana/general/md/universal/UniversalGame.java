package oldmana.general.md.universal;

import java.util.ArrayList;
import java.util.List;

import net.teambrimis.brett.MJNetworkingAPI.MJConnection;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.player.Player;

public abstract class UniversalGame
{
	private List<Card> cardRegistry = new ArrayList<Card>();
	
	private Player[] players = new Player[4];
	
	public UniversalGame()
	{
		
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
	
	public abstract void processPacket(Packet p, MJConnection connection);
	
	public abstract void tick();
}
