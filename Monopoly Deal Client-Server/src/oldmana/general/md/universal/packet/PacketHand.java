package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class PacketHand extends Packet
{
	public static int ID = 7;
	
	private int playerID;
	private int[] cardIDs;
	
	public PacketHand() {}
	
	public PacketHand(int playerID, int[] cardIDs)
	{
		this.playerID = playerID;
		this.cardIDs = cardIDs;
	}
	
	public void setCardIDs(int[] cardIDs)
	{
		this.cardIDs = cardIDs;
	}
	
	public int[] getCardIDs()
	{
		return cardIDs;
	}
	
	public void setPlayerID(int playerID)
	{
		this.playerID = playerID;
	}
	
	public int getPlayerID()
	{
		return playerID;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setPlayerID(data.getInt());
		setCardIDs(data.getInts());
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer buffer = new MJDataBuffer();
		buffer.addShort((short) ID);
		buffer.addInt(getPlayerID());
		buffer.addInts(getCardIDs());
		buffer.finalizeData();
		return buffer.getByteArray();
	}
}
