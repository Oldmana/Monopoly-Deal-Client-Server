package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;
import oldmana.general.md.universal.card.PropertyCard.PropertyType;
import oldmana.general.md.universal.card.PropertyWildCard;

public class PacketPropertyWildCardData extends Packet
{
	public static int ID = 8;
	
	private int cardID;
	private String name;
	private int value;
	
	private PropertyType[] types;
	
	public PacketPropertyWildCardData() {}
	
	public PacketPropertyWildCardData(int cardID, String name, int value, PropertyType[] types)
	{
		this.cardID = cardID;
		this.name = name;
		this.value = value;
		this.types = types;
	}
	
	public PacketPropertyWildCardData(PropertyWildCard card)
	{
		this.cardID = card.getID();
		this.name = card.getName();
		this.value = card.getValue();
		this.types = card.getTypes();
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
	
	public void setPropertyTypes(PropertyType[] types)
	{
		this.types = types;
	}
	
	public PropertyType[] getPropertyTypes()
	{
		return types;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setCardID(data.getInt());
		setName(data.getString());
		setValue(data.getInt());
		setPropertyTypes(new PropertyType[] {PropertyType.typeOf(data.getInt()), PropertyType.typeOf(data.getInt())});
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer data = new MJDataBuffer();
		data.addShort((short) ID);
		data.addInt(getCardID());
		data.addString(getName());
		data.addInt(getValue());
		data.addInt(getPropertyTypes()[0].hashCode());
		data.addInt(getPropertyTypes()[1].hashCode());
		data.finalizeData();
		return data.getByteArray();
	}
}
