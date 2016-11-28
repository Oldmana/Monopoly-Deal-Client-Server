package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;
import oldmana.general.md.client.ClientGame;
import oldmana.general.md.server.ServerGame;
import oldmana.general.md.universal.Universal;
import oldmana.general.md.universal.UniversalGame;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.player.Player;

public class PacketSet extends Packet
{
	public static int ID = 10;
	
	private Player owner;
	
	private int setID;
	private int[] contents;
	
	public PacketSet() {}
	
	public PacketSet(Player owner, int setID, int[] contents)
	{
		this.owner = owner;
		
		this.setID = setID;
		this.contents = contents;
	}
	
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public void setSetID(int setID)
	{
		this.setID = setID;
	}
	
	public int getSetID()
	{
		return setID;
	}
	
	public void setContents(int[] contents)
	{
		this.contents = contents;
	}
	
	public int[] getContents()
	{
		return contents;
	}
	
	public Card[] getCardContents()
	{
		Card[] cards = new Card[contents.length];
		UniversalGame game = Universal.getGame();
		for (int i = 0 ; i < contents.length ; i++)
		{
			cards[i] = game.getCardbyID(contents[i]);
		}
		return cards;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setOwner(Universal.getGame().getPlayerByID(data.getInt()));
		setSetID(data.getInt());
		setContents(data.getInts());
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer buffer = new MJDataBuffer();
		buffer.addShort((short) ID);
		buffer.addInt(getSetID());
		buffer.addInts(getContents());
		buffer.finalizeData();
		return buffer.getByteArray();
	}

}
