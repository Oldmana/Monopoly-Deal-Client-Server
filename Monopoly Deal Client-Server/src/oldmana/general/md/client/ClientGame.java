package oldmana.general.md.client;

import java.util.ArrayList;
import java.util.List;

import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;
import oldmana.general.md.client.card.ClientDeck;
import oldmana.general.md.universal.UniversalGame;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.packet.PacketHand;
import oldmana.general.md.universal.player.Player;

public class ClientGame extends UniversalGame
{
	private static ClientGame game;
	
	private int self;
	private ClientDeck deck;
	
	private List<Card> cardRegistry = new ArrayList<Card>();
	
	public ClientGame()
	{
		game = this;
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
	
	public ClientDeck getDeck()
	{
		return deck;
	}
	
	public void processPacket(Packet p)
	{
		if (p instanceof PacketHand)
		{
			PacketHand packet = (PacketHand) p;
			getPlayerByID(packet.getPlayerID()).getInvisibleHand().setCardCount(packet.getCardIDs().length);
		}
	}
	
	public static ClientGame getGameInstance()
	{
		return game;
	}
}
