package oldmana.general.md.server;

import java.util.List;

import net.teambrimis.brett.MJNetworkingAPI.MJConnection;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;
import oldmana.general.md.server.card.ServerDeck;
import oldmana.general.md.universal.UniversalGame;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.DiscardPile;
import oldmana.general.md.universal.packet.PacketPing;
import oldmana.general.md.universal.packet.PacketPingResponse;
import oldmana.general.md.universal.player.Player;

public class ServerGame extends UniversalGame
{
	private static final double SERVER_VERSION = 0.1;
	
	private static ServerGame game;
	
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
	
	public void charge(Player renter, Player rented, int amount)
	{
		
	}
	
	public void chargeAll(Player renter, int amount)
	{
		
	}
	
	public static ServerGame getGameInstance()
	{
		return game;
	}

	@Override
	public void processPacket(Packet p, MJConnection connection)
	{
		if (p instanceof PacketPing)
		{
			if (((PacketPing) p).getClientVersion() >= SERVER_VERSION)
			{
				PacketPingResponse response = new PacketPingResponse(true, SERVER_VERSION);
				try
				{
					connection.sendPacket(response);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void processPacket(Packet p, Player player)
	{
		
	}

	@Override
	public void tick()
	{
		// TODO Auto-generated method stub
		
	}
}
