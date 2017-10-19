package oldmana.general.md.universal.packet;

import oldmana.general.md.universal.card.PropertyCard;
import oldmana.general.md.universal.card.PropertyCard.PropertyType;

import java.util.ArrayList;
import java.util.List;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class PacketPropertyCardData extends Packet
{
	public static int ID = 5;
	
	private int cardID;
	private String name;
	private int value;
	
	private List<PropertyType> types;
	
	public PacketPropertyCardData() {}
	
	public PacketPropertyCardData(MJDataBuffer data)
	{
		fromBytes(data);
	}
	
	public PacketPropertyCardData(int cardID, String name, int value, PropertyType type)
	{
		this.cardID = cardID;
		this.name = name;
		this.value = value;
		this.types = new ArrayList<PropertyType>(1);
		types.add(type);
	}
	
	public PacketPropertyCardData(int cardID, String name, int value, List<PropertyType> types)
	{
		this.cardID = cardID;
		this.name = name;
		this.value = value;
		this.types = new ArrayList<>(types);
	}
	
	public PacketPropertyCardData(PropertyCard card)
	{
		this.cardID = card.getID();
		this.name = card.getName();
		this.value = card.getValue();
		this.types = new ArrayList<PropertyType>(card.getTypes());
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
		this.types = new ArrayList<PropertyType>();
		types.add(type);
	}
	
	public PropertyType getPropertyType()
	{
		return types.get(0);
	}
	
	public void setPropertyTypes(List<PropertyType> types)
	{
		this.types = types;
	}
	
	public List<PropertyType> getPropertyTypes()
	{
		return types;
	}
	
	public boolean isSolid()
	{
		return types.size() == 1;
	}
	
	/**Constructs a card based on packet data. Should only be used by the client.
	 * 
	 * @return The card from packet data
	 */
	public PropertyCard constructCard()
	{
		return null;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setCardID(data.getInt());
		setName(data.getString());
		setValue(data.getInt());
		int typeCount = data.getByte();
		if (typeCount > 1)
		{
			List<PropertyType> types = new ArrayList<PropertyType>();
			for (int i = 0 ; i < typeCount ; i++)
			{
				types.add(PropertyType.typeOf(data.getInt()));
			}
			setPropertyTypes(types);
		}
		else
		{
			setPropertyType(PropertyType.typeOf(data.getInt()));
		}
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer data = new MJDataBuffer();
		data.addShort((short) ID);
		data.addInt(getCardID());
		data.addString(getName());
		data.addInt(getValue());
		data.addByte((byte) getPropertyTypes().size());
		for (PropertyType type : getPropertyTypes())
		{
			data.addInt(type.hashCode());
		}
		data.finalizeData();
		return data.getByteArray();
	}
}
