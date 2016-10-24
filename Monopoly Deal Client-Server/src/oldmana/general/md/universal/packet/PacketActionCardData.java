package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;
import oldmana.general.md.universal.card.ActionCard.ActionCardType;

public class PacketActionCardData extends Packet
{
	public static int ID = 6;
	
	private int cardID;
	private String name;
	private int value;
	
	private ActionCardType type;
	
	public PacketActionCardData() {}
	
	public PacketActionCardData(int cardID, String name, int value, ActionCardType type)
	{
		this.cardID = cardID;
		this.name = name;
		this.value = value;
		this.type = type;
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
	
	public void setActionCardType(ActionCardType type)
	{
		this.type = type;
	}
	
	public ActionCardType getActionCardType()
	{
		return type;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setCardID(data.getInt());
		setName(data.getString());
		setValue(data.getInt());
		setActionCardType(ActionCardType.typeOf(data.getInt()));
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer data = new MJDataBuffer(16 + 2 * getName().length());
		data.addShort((short) ID);
		data.addInt(getCardID());
		data.addString(getName());
		data.addInt(getValue());
		data.addInt(getActionCardType().hashCode());
		data.finalizeData();
		return data.getByteArray();
	}
}
