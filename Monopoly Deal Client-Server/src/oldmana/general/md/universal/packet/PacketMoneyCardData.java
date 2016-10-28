package oldmana.general.md.universal.packet;

import oldmana.general.md.universal.card.Card;
import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class PacketMoneyCardData extends Packet
{
	public static int ID = 8;
	
	private int cardID;
	private String name;
	private int value;
	
	public PacketMoneyCardData() {}
	
	public PacketMoneyCardData(int cardID, String name, int value)
	{
		this.cardID = cardID;
		this.name = name;
		this.value = value;
	}
	
	public PacketMoneyCardData(Card card)
	{
		this.cardID = card.getID();
		this.name = card.getName();
		this.value = card.getValue();
	}
	
	public void setCardID(int cardID)
	{
		this.cardID = cardID;
	}
	
	public int getCardID()
	{
		return cardID;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setCardID(data.getInt());
		setName(data.getString());
		setValue(data.getInt());
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer data = new MJDataBuffer();
		data.addShort((short) ID);
		data.addInt(getCardID());
		data.addString(getName());
		data.addInt(getValue());
		data.finalizeData();
		return data.getByteArray();
	}
}
