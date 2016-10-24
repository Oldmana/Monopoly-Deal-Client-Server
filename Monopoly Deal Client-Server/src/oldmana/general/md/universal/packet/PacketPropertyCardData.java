package oldmana.general.md.universal.packet;

import oldmana.general.md.universal.card.PropertyCard.PropertyType;
import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class PacketPropertyCardData extends Packet
{
	public static int ID = 5;
	
	private int cardID;
	private String name;
	private int value;
	
	private PropertyType type;
	
	public PacketPropertyCardData() {}
	
	public PacketPropertyCardData(int cardID, String name, int value, PropertyType type)
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
	
	public void setPropertyType(PropertyType type)
	{
		this.type = type;
	}
	
	public PropertyType getPropertyType()
	{
		return type;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setCardID(data.getInt());
		setName(data.getString());
		setValue(data.getInt());
		setPropertyType(PropertyType.typeOf(data.getInt()));
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer data = new MJDataBuffer();
		data.addShort((short) ID);
		data.addInt(getCardID());
		data.addString(getName());
		data.addInt(getValue());
		data.addInt(getPropertyType().hashCode());
		data.finalizeData();
		return data.getByteArray();
	}
}
